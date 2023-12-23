package _2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Puzzle9 {

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2023/Puzzle9Input.txt"));
        int total = 0;
        for (String input : inputs) {
            String vals[] = input.split(" ");
            // Collections.reverse(Arrays.asList(vals));   // Part 2
            List<Integer> newVals = new ArrayList<>();
            for (int i = 0; i < vals.length - 1; i++) {
                int val1 = Integer.valueOf(vals[i]);
                int val2 = Integer.valueOf(vals[i + 1]);
                int diff = val2 - val1;
                newVals.add(diff);
            }
            int res = Integer.valueOf(vals[vals.length - 1]) + newVals.get(newVals.size() - 1);
            int lastIndex = 1;
            while (!newVals.stream().allMatch(a -> a == 0)) {
                for (int i = 0; i < newVals.size() - 1; i++) {
                    int val1 = Integer.valueOf(newVals.get(i));
                    int val2 = Integer.valueOf(newVals.get(i + 1));
                    int diff = val2 - val1;
                    newVals.set(i, diff);
                }
                newVals.set(newVals.size() - lastIndex, 0);
                res = res + newVals.get(newVals.size() - (lastIndex + 1));
                lastIndex++;
            }
            total = total + res;
        }
        System.out.println(total);
    }
}
