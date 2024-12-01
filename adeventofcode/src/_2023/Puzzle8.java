package _2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Puzzle8 {


    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2023/Puzzle8Input.txt"));
        char[] directions = inputs.get(0).toCharArray();
        Map<String, Pair> coOrdinatesMap = new HashMap<>();
        List<String> sources = new ArrayList<>();
        for (int i = 2; i < inputs.size(); i++) {
            String value = inputs.get(i);
            String source = value.substring(0, 3);
            String left = value.substring(7, 10);
            String right = value.substring(12, 15);
            Pair pair = new Pair(left, right);
            coOrdinatesMap.put(source, pair);

            String a = value.substring(2, 3);
            if (a.equals("A")) {
                sources.add(source);
            }
        }

        int path = 0;
        List<Integer> paths = new ArrayList<>();
        while (paths.size() < 6) {
            for (int i = 0; i < directions.length; i++) {
                for (int j = 0; j < sources.size(); j++) {
                    Pair start = coOrdinatesMap.get(sources.get(j));
                    if (directions[i] == 'L') {
                        sources.set(j, start.left());
                    } else {
                        sources.set(j, start.right());
                    }
                }
                path++;
                if (sources.stream().anyMatch(a -> a.substring(2, 3).equals("Z"))) {
                    paths.add(path);
                    break;
                }
            }
        }
        long lcm = paths.get(0);
        int i = 1;
        while (i < 6) {
            int v2 = paths.get(i);
            lcm = findLcm(lcm, v2);
            i++;
        }
        System.out.println(lcm);
    }

    public static long findLcm(long v1, long v2) {
        long highNumber = Math.max(v1, v2);
        long lowNumber = Math.min(v1, v2);
        long lcm = highNumber;
        while (lcm % lowNumber != 0) {
            lcm += highNumber;
        }
        return lcm;
    }

    public static void main1(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2023/Puzzle8Input.txt"));
        char[] directions = inputs.get(0).toCharArray();
        Map<String, Pair> coOrdinatesMap = new HashMap<>();
        for (int i = 2; i < inputs.size(); i++) {
            String value = inputs.get(i);
            String source = value.substring(0, 3);
            String left = value.substring(7, 10);
            String right = value.substring(12, 15);
            Pair pair = new Pair(left, right);
            coOrdinatesMap.put(source, pair);
        }

        int path = 0;
        String source = "AAA";
        while (!source.equals("ZZZ")) {
            for (int i = 0; i < directions.length; i++) {
                Pair start = coOrdinatesMap.get(source);
                if (directions[i] == 'L') {
                    source = start.left();
                } else {
                    source = start.right();
                }
                path++;
                if (source.equals("ZZZ")) {
                    break;
                }
            }
        }
        System.out.println(path);
    }

    static record Pair(String left, String right) {

    }
}
