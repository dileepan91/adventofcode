package _2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Puzzle6 {

    public static void main(String[] args) throws IOException {
        Puzzle6 puzzle6 = new Puzzle6();
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2022/Puzzle6Input.txt"));
        Queue<Character> queue = new LinkedList<>();
        char[] input = inputs.get(0).toCharArray();

        int distinctCharSize = 14;  // 4 for problem 1
        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);

            if (i >= distinctCharSize-1) {
                boolean isQueueUnique = puzzle6.isQueueUnique(queue, distinctCharSize);
                if (isQueueUnique) {
                    System.out.println(i+1);
                    break;
                }
                queue.poll();
            }
        }
    }

    private boolean isQueueUnique(Queue<Character> queue, int distinctCharSize) {
        boolean isQueueUnique = false;
        Set<Character> uniqueEle = new HashSet<>();
        queue.forEach(a -> {
            uniqueEle.add(a);
        });
        if (uniqueEle.size() == distinctCharSize) {
            isQueueUnique = true;
        }
        return isQueueUnique;
    }
}
