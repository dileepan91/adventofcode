package _2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Puzzle2 {

    public static void main1(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2024/Puzzle2Input.txt"));
        int safe = 0;
        for (String input : inputs) {
            String[] levels = input.split(" ");
            boolean isNotSafe = false;
            int neg = 0, pos = 0;
            for (int i = 0; i < levels.length - 1; i++) {
                int diff = Integer.parseInt(levels[i]) - Integer.parseInt(levels[i + 1]);

                if (diff < 0) {
                    neg++;
                } else if (diff > 0) {
                    pos++;
                }

                if (Math.abs(diff) < 1 || Math.abs(diff) > 3 || (neg > 0 && pos > 0)) {
                    isNotSafe = true;
                    break;
                }
            }

            if (!isNotSafe) {
                safe++;
            }
        }
        System.out.println(safe);
    }

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2024/Puzzle2Input.txt"));
        int safe = 0;
        for (String input : inputs) {
            String[] levels = input.split(" ");
            boolean isNotSafe = false;
            int neg = 0, pos = 0, exceedThreshold = 0;
            for (int i = 0; i < levels.length - 1; i++) {
                int diff = Integer.parseInt(levels[i]) - Integer.parseInt(levels[i + 1]);

                if (diff < 0) {
                    neg++;
                } else if (diff > 0) {
                    pos++;
                }

                if (Math.abs(diff) < 1 || Math.abs(diff) > 3 || (neg > 0 && pos > 0)) {
                    isNotSafe = true;
                    exceedThreshold++;
                    break;
                }
            }

            if (!isNotSafe || exceedThreshold > 0) {
                System.out.println(Arrays.asList(levels));
                safe++;
            }
        }
        System.out.println(safe);
    }


    public static void main2(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2024/Puzzle2Input.txt"));
        int safe = 0;
        List<List<Integer>> levelDiffs = new ArrayList<>();
        for (String input : inputs) {
            String[] levels = input.split(" ");
            List<Integer> levelDiff = new ArrayList<>();
            for (int i = 0; i < levels.length - 1; i++) {
                int diff = Integer.parseInt(levels[i]) - Integer.parseInt(levels[i + 1]);
                levelDiff.add(diff);
            }
            levelDiffs.add(levelDiff);
        }

        for (List<Integer> levels : levelDiffs) {
            for (Integer diff : levels) {

            }
        }
        System.out.println(safe);
    }
}
