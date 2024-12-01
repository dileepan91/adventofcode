package _2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Puzzle1 {
    public static void main1(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2024/Puzzle1Input.txt"));
        List<Integer> leftLocationIds = new ArrayList<>();
        List<Integer> rightLocationIds = new ArrayList<>();
        for(String input:inputs) {
            String[] locationIds = input.split("   ");
            leftLocationIds.add(Integer.valueOf(locationIds[0]));
            rightLocationIds.add(Integer.valueOf(locationIds[1]));
        }

        Collections.sort(leftLocationIds);
        Collections.sort(rightLocationIds);

        long totalDistance = 0;
        for(int i=0;i<leftLocationIds.size();i++) {
            totalDistance = totalDistance + Math.abs(rightLocationIds.get(i) - leftLocationIds.get(i));
        }

        System.out.println(totalDistance);
    }

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2024/Puzzle1Input.txt"));
        List<Integer> leftLocationIds = new ArrayList<>();
        Map<Integer, Integer> rightLocationIdsMap = new HashMap<>();
        for(String input:inputs) {
            String[] locationIds = input.split("   ");
            leftLocationIds.add(Integer.valueOf(locationIds[0]));
            rightLocationIdsMap.compute(Integer.valueOf(locationIds[1]), (key, value) -> (value == null) ? 1 : value+1);
        }

        long totalDistance = 0;
        for(Integer leftLocationId:leftLocationIds) {
            totalDistance = totalDistance + ((long) leftLocationId * rightLocationIdsMap.getOrDefault(leftLocationId, 0));
        }

        System.out.println(totalDistance);
    }
}
