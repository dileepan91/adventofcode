package _2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Puzzle7 {

    Directory root;

    class File {
        String fileName;
        int size;

        File(String fileName, int size) {
            this.fileName = fileName;
            this.size = size;
        }

        public String getFileName() {
            return fileName;
        }

        public int getSize() {
            return size;
        }
    }

    class Directory {
        List<File> files;
        List<Directory> directories;
        String dirName;
        Directory parentDirectory;

        Directory(String dirName, Directory parentDirectory) {
            this.dirName = dirName;
            directories = new ArrayList<>();
            files = new ArrayList<>();
            this.parentDirectory = parentDirectory;
        }

        public List<File> getFiles() {
            return files;
        }

        public List<Directory> getDirectories() {
            return directories;
        }

        public String getDirName() {
            return dirName;
        }

        public Directory getParentDirectory() {
            return parentDirectory;
        }
    }

    public static void main(String[] args) throws IOException {
        Puzzle7 puzzle7 = new Puzzle7();
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2022/Puzzle7Input.txt"));
        puzzle7.solveProblem1(inputs);
        List<Directory> directoriesWithFileSystem = puzzle7.root.getDirectories();
        Map<String, Integer> directoryToSize = new HashMap<>();
        puzzle7.calculateEachDirectorySize(directoriesWithFileSystem, directoryToSize);
        int totalSizeLessThan100000 = calculateDirectoriesSizeLessThan100000(directoryToSize);
        System.out.println("Problem 1 Solution: " + totalSizeLessThan100000);


        int totalSize = 0;
        for(Directory directoryWithFileSystem:directoriesWithFileSystem){
            totalSize = totalSize + directoryToSize.get(directoryWithFileSystem.getParentDirectory().getDirName()+directoryWithFileSystem.getDirName());
        }
        int spaceToFree = 30000000 - (70000000 - totalSize);

        List<Integer> deletableSpaces = directoryToSize.values().stream().filter(a -> a > spaceToFree).collect(Collectors.toList());

        int smallestAmongDeletable = deletableSpaces.stream().mapToInt(i->i).min().orElse(0);
        System.out.println("Problem 2 Solution: " + smallestAmongDeletable);

    }

    private static int calculateDirectoriesSizeLessThan100000(Map<String, Integer> directoryToSize) {
        return directoryToSize.values().stream().filter(a -> a < 100000).mapToInt(Integer::intValue).sum();
    }

    public void calculateEachDirectorySize(List<Directory> directories, Map<String, Integer> directoryToSize) {

        for (Directory dir : directories) {
            int filesSize = calculateFilesSize(dir.getFiles());
            String dirName = dir.getParentDirectory().getDirName() + dir.getDirName();
            if (directoryToSize.containsKey(dirName)) {
                int size = directoryToSize.get(dirName);
                directoryToSize.put(dirName, filesSize + size);
            } else {
                directoryToSize.put(dirName, filesSize);
            }

            Directory parent = dir.getParentDirectory();
            while (parent != null) {
                if (parent.getParentDirectory() != null) {
                    String dirNameP = parent.getParentDirectory().getDirName() + parent.getDirName();
                    if (directoryToSize.containsKey(dirNameP)) {
                        int size = directoryToSize.get(dirNameP);
                        directoryToSize.put(dirNameP, filesSize + size);
                    }
                }
                parent = parent.getParentDirectory();
            }


            List<Directory> inDirectories = dir.getDirectories();
            if (!inDirectories.isEmpty()) {
                calculateEachDirectorySize(inDirectories, directoryToSize);
            }
        }
    }

    private int calculateFilesSize(List<File> files) {
        int fileSize = 0;
        for (File file : files) {
            fileSize = fileSize + file.getSize();
        }
        return fileSize;
    }

    public void solveProblem1(List<String> inputs) {
        Directory directory = new Directory("/", null);
        root = directory;

        for (int i = 1; i < inputs.size(); i++) {
            String input = inputs.get(i);
            String[] cmds = input.split(" ");
            List<Directory> directories = directory.getDirectories();
            if (cmds[0].equals("$")) {
                if (cmds[1].equals("cd")) {
                    if (cmds[2].equals("..")) {
                        directory = directory.getParentDirectory();
                    } else {
                        Optional<Directory> optionalDirectory = findDirectory(directories, cmds[2]);
                        if (optionalDirectory.isPresent()) {
                            directory = optionalDirectory.get();
                        } else {
                            Directory directoryInner = new Directory(cmds[2], directory);
                            directories.add(directoryInner);
                            directory = directoryInner;
                        }
                    }
                }
            } else if (cmds[0].equals("dir")) {
                Directory directoryInner = new Directory(cmds[1], directory);
                directories.add(directoryInner);
            } else {
                File file = new File(cmds[1], Integer.valueOf(cmds[0]));
                directory.getFiles().add(file);
            }
        }
    }

    public Optional<Directory> findDirectory(List<Directory> directories, String dirToFind) {
        return directories.stream().filter(dir -> dir.getDirName().equals(dirToFind)).findFirst();
    }
}
