package _2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Puzzle4 {

    public static void main1(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2023/Puzzle4Input.txt"));
        int totalWorth = 0;
        for (String input : inputs) {
            String vals[] = input.split(":")[1].trim().split("\\|");
            String winVals[] = vals[0].trim().split(" ");
            String myVals[] = vals[1].trim().split(" ");
            Set<String> winValSet = Arrays.stream(winVals).filter(a -> !a.isEmpty()).collect(Collectors.toSet());
            Set<String> myValSet = Arrays.stream(myVals).filter(a -> !a.isEmpty()).collect(Collectors.toSet());
            int point = 0;
            for (String myVal : myValSet) {
                if (winValSet.contains(myVal)) {
                    point++;
                }
            }
            System.out.println(point);
            if (point > 0) {
                totalWorth = (int) (totalWorth + Math.pow(2, point - 1));
            }
        }
        System.out.println(totalWorth);
    }

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2023/Puzzle4Input.txt"));
        Map<Integer, Integer> cardToInstancesMap = new HashMap<>();
        for (String input : inputs) {
            String cards[] = input.split(":");
            String cardVals[] = cards[0].split(" ");
            int cardVal = Integer.valueOf(cardVals[cardVals.length - 1]);
            String vals[] = cards[1].trim().split("\\|");
            String winVals[] = vals[0].trim().split(" ");
            String myVals[] = vals[1].trim().split(" ");
            Set<String> winValSet = Arrays.stream(winVals).filter(a -> !a.isEmpty()).collect(Collectors.toSet());
            Set<String> myValSet = Arrays.stream(myVals).filter(a -> !a.isEmpty()).collect(Collectors.toSet());
            int point = 0;
            for (String myVal : myValSet) {
                if (winValSet.contains(myVal)) {
                    point++;
                }
            }

            int instance =1 ;
            int calculatedCurrentInstance = 1;

            for (int i = cardVal; (i <= point + cardVal ) ; i++) {
                if (cardToInstancesMap.containsKey(i)) {
                    instance = cardToInstancesMap.get(i);
                    if (i == cardVal) {
                        calculatedCurrentInstance = ++instance;
                    } else {
                        instance = (calculatedCurrentInstance + instance);
                    }
                } else {
                    if (i != cardVal) {
                        // if it is a copy instance, then newly added card should have the current instance value
                        instance = calculatedCurrentInstance;
                    }
                }
                cardToInstancesMap.put(i, instance);
            }
        }

        System.out.println(cardToInstancesMap.values().stream().mapToInt(i -> i).sum());
    }
}
