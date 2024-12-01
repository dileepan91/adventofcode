package _2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle2 {

    static int red = 12;
    static int green = 13;
    static int blue = 14;

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2023/Puzzle2Input.txt"));
        int gameNumberTotal = 0;
        for (String input : inputs) {
            int greens = 1;
            int blues = 1;
            int reds = 1;
            String[] splits = input.substring(input.indexOf(':') + 1).split(";");
            for (String split : splits) {
                String[] rolls = split.split(",");
                for (String roll : rolls) {
                    String[] dices = roll.trim().split(" ");
                    String color = dices[1].trim();
                    int val = Integer.valueOf(dices[0].trim());
                    switch (color) {
                        case "green":
                            if(greens < val) {
                                greens = val;
                            }
                            break;
                        case "red":
                            if(reds < val) {
                                reds = val;
                            }
                            break;
                        case "blue":
                            if(blues < val) {
                                blues = val;
                            }
                    }
                }
            }
            gameNumberTotal = gameNumberTotal + (blues * greens * reds);

        }
        System.out.println(gameNumberTotal);
    }

    public static void main1(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2023/Puzzle2Input.txt"));
        int gameNumberTotal = 0;
        for (String input : inputs) {

            int gameNumber = Integer.valueOf(input.substring(5, input.indexOf(':')));
            String[] splits = input.substring(input.indexOf(':') + 1).split(";");
            boolean isGamePossible = true;
            for (String split : splits) {
                int greens = 0;
                int blues = 0;
                int reds = 0;
                String[] rolls = split.split(",");
                for (String roll : rolls) {
                    String[] dices = roll.trim().split(" ");
                    String color = dices[1].trim();
                    int val = Integer.valueOf(dices[0].trim());
                    switch (color) {
                        case "green":
                            greens = greens + val;
                            break;
                        case "red":
                            reds = reds + val;
                            break;
                        case "blue":
                            blues = blues + val;
                    }
                }
                if (greens > green || reds > red || blues > blue) {
                    isGamePossible = false;
                    break;
                }
            }
            if (isGamePossible) {
                gameNumberTotal = gameNumberTotal + gameNumber;
            }
        }
        System.out.println(gameNumberTotal);
    }
}
