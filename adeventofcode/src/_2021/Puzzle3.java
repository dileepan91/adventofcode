package _2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Puzzle3 {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("adeventofcode/src/_2021/Puzzle3Input.txt"));
        List<String> input2 = new ArrayList<>(input);
        Puzzle3 p = new Puzzle3();
        int i = 0;
        while(input.size() != 1) {
           input.retainAll(p.loop(input, i));
            i++;
        }

        i = 0;
        while(input2.size() != 1) {
            input2.removeAll(p.loop(input2, i));
            i++;
        }

        System.out.println(input);
        System.out.println(input2);
        System.out.println("Life Support Rating :"+
                (Integer.parseInt(input.get(0),2)) * Integer.parseInt(input2.get(0),2));
  }

    public List<String> loop(List<String> input, int i) {
        List<String> zeroList = new ArrayList<>();
        List<String> oneList = new ArrayList<>();
        Counter counter = new Counter();
        for (String val : input) {
            char[] bits = val.toCharArray();
            int temp = Integer.valueOf(Character.toString(bits[i]));
            if (temp == 0) {
                counter.incrementZero();
                zeroList.add(val);
            } else {
                counter.incrementOne();
                oneList.add(val);
            }
        }

        if(counter.getOne() >= counter.getZero()) {
            return oneList;
        } else {
            return zeroList;
        }
    }

    public static void main1(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("adeventofcode/src/_2021/Puzzle3Input.txt"));
        Map<Integer, Counter> map = new HashMap<>();
        for (String val : input) {
            char[] bits = val.toCharArray();
            for (int i = 0; i < bits.length; i++) {
                Counter counter = null;
                int temp = Integer.valueOf(Character.toString(bits[i]));
                if (map.containsKey(i)) {
                    counter = map.get(i);
                    if (temp == 0) {
                        counter.incrementZero();
                    } else {
                        counter.incrementOne();
                    }
                } else {
                    counter = new Counter();
                    if (temp == 0) {
                        counter.incrementZero();
                    } else {
                        counter.incrementOne();
                    }
                    map.put(i, counter);
                }
            }
        }

        Set<Map.Entry<Integer, Counter>> entrySet = map.entrySet();
        String gamma = "";
        String epsilon = "";
        for (Map.Entry<Integer, Counter> entry : entrySet) {
            Counter counter = entry.getValue();
            if (counter.getOne() > counter.getZero()) {
                gamma = gamma + 1;
                epsilon = epsilon + 0;
            } else {
                gamma = gamma + 0;
                epsilon = epsilon + 1;
            }
        }
        System.out.println(gamma);
        System.out.println(epsilon);
        System.out.println("Power Consumption : " + (Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)));
    }


}