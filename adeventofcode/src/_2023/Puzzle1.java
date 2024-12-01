package _2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Puzzle1 {

    public static void main(String[] args) throws IOException {
        Puzzle1 po = new Puzzle1();
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2023/Puzzle1Input.txt"));
        int num = 0;
        for (String input : inputs) {
            char[] inputChars = input.toCharArray();
            char firstNum = '0';
            char lastNum = '0';
            for (int i = 0; i < inputChars.length; i++) {
                StringBuilder sb = new StringBuilder();
                char val = po.findFirst(inputChars, i, sb, inputChars.length);
                if (val != '0') {
                    firstNum = val;
                    break;
                }
            }
            //System.out.println(firstNum);

            for (int i = inputChars.length - 1; i >= 0; i--) {
                StringBuilder sb = new StringBuilder();
                char val = po.findLast(inputChars, i, sb);
                if (val != '0') {
                    lastNum = val;
                    break;
                }
            }
            //System.out.println(lastNum);
            num = num + Integer.parseInt("" + firstNum + lastNum);
        }

        System.out.println(num);
    }

    Map<String, Character> cons = Map.of("one", '1', "two", '2', "three", '3', "four", '4', "five", '5', "six", '6', "seven", '7', "eight", '8', "nine", '9');

    private char findFirst(char[] inputChars, int i, StringBuilder s, int len) {
        char a = inputChars[i];
        s.append(inputChars[i]);
        if (Character.isDigit(a)) {
            return a;
        } else {
            if (a != 'o' && a != 't' && a != 's' && a != 'f' && a != 'e' && a != 'n') {
                return '0';
            }
            if (i + 2 >= len) {
                return '0';
            }
            s.append(inputChars[i + 1]).append(inputChars[i + 2]);
            if (cons.containsKey(s.toString())) {
                return cons.get(s.toString());
            }
            if (i + 3 >= len) {
                return '0';
            }
            s.append(inputChars[i + 3]);
            if (cons.containsKey(s.toString())) {
                return cons.get(s.toString());
            }
            if (i + 4 >= len) {
                return '0';
            }
            s.append(inputChars[i + 4]);
            if (cons.containsKey(s.toString())) {
                return cons.get(s.toString());
            }
        }
        return '0';
    }

    private char findLast(char[] inputChars, int i, StringBuilder s) {
        char a = inputChars[i];
        s.append(inputChars[i]);
        if (Character.isDigit(a)) {
            return a;
        } else {
            if (a != 'o' && a != 'r' && a != 'x' && a != 't' && a != 'e' && a != 'n') {
                return '0';
            }
            if (i - 2 < 0) {
                return '0';
            }
            s.append(inputChars[i - 1]).append(inputChars[i -2]);
            s.reverse();
            if (cons.containsKey(s.toString())) {
                return cons.get(s.toString());
            }
            if (i - 3 < 0) {
                return '0';
            }
            s.reverse();
            s.append(inputChars[i - 3]);
            s.reverse();
            if (cons.containsKey(s.toString())) {
                return cons.get(s.toString());
            }
            if (i - 4 < 0) {
                return '0';
            }
            s.reverse();
            s.append(inputChars[i - 4]);
            s.reverse();
            if (cons.containsKey(s.toString())) {
                return cons.get(s.toString());
            }
        }
        return '0';
    }


    public static void main1(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2023/Puzzle1Input.txt"));
        int num = 0;
        for (String input : inputs) {
            char[] inputChars = input.toCharArray();
            char firstNum = '0';
            char lastNum = '0';
            for (int i = 0; i < inputChars.length; i++) {
                if (Character.isDigit(inputChars[i])) {
                    firstNum = inputChars[i];
                    break;
                }
            }

            for (int i = inputChars.length - 1; i >= 0; i--) {
                if (Character.isDigit(inputChars[i])) {
                    lastNum = inputChars[i];
                    break;
                }
            }

            num = num + Integer.parseInt("" + firstNum + lastNum);
        }
        System.out.println(num);
    }

}
