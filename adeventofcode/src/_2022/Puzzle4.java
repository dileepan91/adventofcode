package _2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle4 {

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2022/Puzzle4Input.txt"));

        int overlapPair = 0;

        for (String input : inputs) {
            String[] splitInput = input.split(",");
            String[] group1 = splitInput[0].split("-");
            String[] group2 = splitInput[1].split("-");

            int g1a = Integer.valueOf(group1[0]);
            int g1b = Integer.valueOf(group1[1]);

            int g2a = Integer.valueOf(group2[0]);
            int g2b = Integer.valueOf(group2[1]);

            if (g1a >= g2a) {
                if (g1b <= g2b) {
                    overlapPair++;
                    continue;
                }
            }

            if (g2a >= g1a) {
                if (g2b <= g1b) {
                    overlapPair++;
                    continue;
                }
            }

            if(g1a <= g2b) {
                if(g1b > g2a) {
                    overlapPair++;
                    continue;
                }
            }

            if(g2a <= g1b) {
                if(g2b > g1a) {
                    overlapPair++;
                    continue;
                }
            }
        }
        System.out.println(overlapPair);
    }

    public static void main1(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2022/Puzzle4Input.txt"));

        int overlapPair = 0;

        for (String input : inputs) {
            String[] splitInput = input.split(",");
            String[] group1 = splitInput[0].split("-");
            String[] group2 = splitInput[1].split("-");

            int g1a = Integer.valueOf(group1[0]);
            int g1b = Integer.valueOf(group1[1]);

            int g2a = Integer.valueOf(group2[0]);
            int g2b = Integer.valueOf(group2[1]);

            if (g1a >= g2a) {
                if (g1b <= g2b) {
                    overlapPair++;
                    continue;
                }
            }

            if (g2a >= g1a) {
                if (g2b <= g1b) {
                    overlapPair++;
                }
            }
        }
        System.out.println(overlapPair);
    }
}
