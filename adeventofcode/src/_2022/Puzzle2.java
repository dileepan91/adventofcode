package _2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Puzzle2 {

    public static void main(String[] args) throws IOException {
        Map<String, String> points = new HashMap<>();
        points.put("AL", "Z");
        points.put("CL", "Y");
        points.put("BL", "X");

        points.put("AW", "Y");
        points.put("BW", "Z");
        points.put("CW", "X");

        points.put("AT", "X");
        points.put("BT", "Y");
        points.put("CT", "Z");

        Map<String, Integer> scores = new HashMap<>();
        scores.put("W", 6);
        scores.put("L", 0);
        scores.put("T", 3);

        Map<String, String> wls = new HashMap<>();
        wls.put("X", "L");
        wls.put("Y", "T");
        wls.put("Z", "W");


        Map<String, Integer> indPoints = new HashMap<>();
        indPoints.put("X", 1);
        indPoints.put("Y", 2);
        indPoints.put("Z", 3);

        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2022/Puzzle2Input.txt"));
        int totalScore = 0;
        for (String input : inputs) {
            String[] a = input.split(" ");
            String td = wls.get(a[1]);
            int p = scores.get(td);
            String res = points.get(a[0]+td);
            p = p+indPoints.get(res);
            totalScore = totalScore+p;
        }

        System.out.println(totalScore);

    }


    public static void main1(String[] args) throws IOException {
        Map<String, String> points = new HashMap<>();
        points.put("A Z", "L");
        points.put("C Y", "L");
        points.put("B X", "L");

        points.put("A Y", "W");
        points.put("B Z", "W");
        points.put("C X", "W");

        points.put("A X", "T");
        points.put("B Y", "T");
        points.put("C Z", "T");

        Map<String, Integer> scores = new HashMap<>();
        scores.put("W", 6);
        scores.put("L", 0);
        scores.put("T", 3);

        Map<String, Integer> indPoints = new HashMap<>();
        indPoints.put("X", 1);
        indPoints.put("Y", 2);
        indPoints.put("Z", 3);

        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2022/Puzzle2Input.txt"));
        int totalScore = 0;
        for (String input : inputs) {
            String result = points.get(input);
            int p = scores.get(result);
            String[] a = input.split(" ");
            p = p + indPoints.get(a[1]);
            totalScore = totalScore + p;
        }

        System.out.println(totalScore);

    }
}
