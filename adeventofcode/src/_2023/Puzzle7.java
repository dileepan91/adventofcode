package _2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Puzzle7 {

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2023/Puzzle7Input.txt"));
        TreeSet<String> fives = new TreeSet<>(new CardComparator());
        TreeSet<String> fours = new TreeSet<>(new CardComparator());
        TreeSet<String> fulls = new TreeSet<>(new CardComparator());
        TreeSet<String> threes = new TreeSet<>(new CardComparator());
        TreeSet<String> twos = new TreeSet<>(new CardComparator());
        TreeSet<String> ones = new TreeSet<>(new CardComparator());
        TreeSet<String> highs = new TreeSet<>(new CardComparator());
        Map<String, Integer> cardToBid = new HashMap<>();
        for (String input : inputs) {
            String values[] = input.split(" ");
            String cardValue = values[0];
            char[] cards = cardValue.toCharArray();
            int bid = Integer.valueOf(values[1]);
            cardToBid.put(cardValue, bid);

            Map<Character, Integer> temp = new HashMap<>();
            //int max = arrangeCard(cards, temp);   // part 1
            int max = arrangeCard2(cards, temp);

            switch (max) {
                case 5:
                    if (!fives.add(cardValue)) {
                        System.out.println(cardValue);
                    }
                    break;
                case 4:
                    if (!fours.add(cardValue)) {
                        System.out.println(cardValue);
                    }
                    break;
                case 3:
                    if (temp.size() == 3) {
                        threes.add(cardValue);
                    } else {
                        fulls.add(cardValue);
                    }
                    break;
                case 2:
                    if (temp.size() == 3) {
                        twos.add(cardValue);
                    } else {
                        ones.add(cardValue);
                    }
                    break;
                case 1:
                    highs.add(cardValue);
            }
        }
        int rank = cardToBid.size();
        List<TreeSet<String>> allSets = Arrays.asList(fives, fours, fulls, threes, twos, ones, highs);
        int total = calculate(cardToBid, allSets, rank);
        System.out.println(total);
    }

    //252656917
    private static int arrangeCard(char[] cards, Map<Character, Integer> temp) {
        for (int i = 0; i < 5; i++) {
            int c = 1;
            if (temp.containsKey(cards[i])) {
                c = temp.get(cards[i]);
                c++;
            }
            temp.put(cards[i], c);
        }
        return temp.values().stream().mapToInt(a -> a).max().getAsInt();
    }

    //253499763
    private static int arrangeCard2(char[] cards, Map<Character, Integer> temp) {
        int j = 0;
        for (int i = 0; i < 5; i++) {
            int c = 1;
            if(cards[i] == 'J') {
                j++;
                continue;
            }
            if (temp.containsKey(cards[i])) {
                c = temp.get(cards[i]);
                c++;
            }
            temp.put(cards[i], c);
        }
        return temp.values().stream().mapToInt(a -> a).max().orElse(0) + j;
    }

    public static int calculate(Map<String, Integer> cardToBid, List<TreeSet<String>> allSets, int rank) {
        int total = 0;
        for (TreeSet<String> set : allSets) {
            for (String five : set) {
                total = total + (cardToBid.get(five) * rank);
                rank--;
            }
        }

        return total;
    }

    static class CardComparator implements Comparator<String> {


        @Override
        public int compare(String o1, String o2) {
            for (int i = 0; i < 5; i++) {
                int o1Val = getNumericValue(o1.charAt(i));
                int o2Val = getNumericValue(o2.charAt(i));
                if (o1Val == o2Val) {
                    continue;
                }
                if (o1Val > o2Val) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return 0;
        }

        private int getNumericValue(char input) {
            switch (input) {
                case 'A':
                    return 5000;
                case 'K':
                    return 4000;
                case 'Q':
                    return 3000;
                case 'J':
                    // return 2000; // part 1
                    return 1;
                case 'T':
                    return 1000;
                default:
                    return input;
            }
        }
    }
}
