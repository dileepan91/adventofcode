package _2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle3 {

    static char dot = '.';


    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2023/Puzzle3Input.txt"));
        int totalPartNumber = 0;
        for (int i = 1; i < inputs.size() - 1; i++) {

            char[] inputUp = inputs.get(i - 1).toCharArray();

            char[] mainInput = inputs.get(i).toCharArray();

            char[] inputDown = inputs.get(i + 1).toCharArray();

            for (int j = 0; j < mainInput.length; j++) {
                char presentVal = mainInput[j];
                if (presentVal == '*') {
                    int leftVal = getAdjacentNumberLeft(mainInput, j);
                    int rightVal = getAdjacentNumberRight(mainInput, j);
                    int upVal = 1;
                    int leftUpVal = 1;
                    int rightUpVal = 1;
                    int downVal = 1;
                    int leftDownVal = 1;
                    int rightDownVal = 1;


                    if (Character.isDigit(inputUp[j])) {
                        upVal = getAdjacentNumber(inputUp, j);
                    } else {
                        leftUpVal = getAdjacentNumberLeft(inputUp, j);
                        rightUpVal = getAdjacentNumberRight(inputUp, j);
                    }


                    if (Character.isDigit(inputDown[j])) {
                        downVal = getAdjacentNumber(inputDown, j);
                    } else {
                        leftDownVal = getAdjacentNumberLeft(inputDown, j);
                        rightDownVal = getAdjacentNumberRight(inputDown, j);
                    }

                    int gearValue = calculateGearValue(leftVal, rightVal, upVal, leftUpVal, rightUpVal, downVal, leftDownVal, rightDownVal);

                    if (gearValue != 0) {
                        totalPartNumber = totalPartNumber + gearValue;
                    }
                }
            }
        }
        System.out.println(totalPartNumber);
    }

    private static int calculateGearValue(int... val) {
        int count = 0;
        int gearSum = 1;
        for (int i = 0; i < val.length; i++) {
            if (val[i] > 1) {
                count++;
                gearSum = gearSum * val[i];
            }
        }
        if (count == 2) {
            return gearSum;
        } else {
            return 0;
        }
    }

    private static int getAdjacentNumber(char[] input, int pos) {
        StringBuilder sb = new StringBuilder();
        sb.append(getAdjacentLeft(input, pos));
        sb.append(input[pos]);
        sb.append(getAdjacentRight(input, pos));
        return convertToInteger(sb);
    }

    private static Integer getAdjacentNumberRight(char[] input, int pos) {
        StringBuilder sb = getAdjacentRight(input, pos);
        return convertToInteger(sb);
    }

    private static StringBuilder getAdjacentRight(char[] input, int pos) {
        int af = pos + 1;
        StringBuilder sb = new StringBuilder();
        while (af < input.length) {
            char val = input[af];
            if (Character.isDigit(val)) {
                sb.append(val);
                af = af + 1;
            } else {
                break;
            }
        }
        return sb;
    }

    private static Integer getAdjacentNumberLeft(char[] input, int pos) {
        StringBuilder sb = getAdjacentLeft(input, pos);
        return convertToInteger(sb);
    }

    private static StringBuilder getAdjacentLeft(char[] input, int pos) {
        int bf = pos - 1;
        StringBuilder sb = new StringBuilder();
        while (bf >= 0) {
            char val = input[bf];
            if (Character.isDigit(val)) {
                sb.append(val);
                bf = bf - 1;
            } else {
                break;
            }
        }
        return sb.reverse();
    }

    private static Integer convertToInteger(StringBuilder sb) {
        if (sb.isEmpty()) {
            return 1;
        }
        return Integer.valueOf(sb.toString());
    }

    //7297185
    public static void main1(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2023/Puzzle3Input.txt"));
        int totalPartNumber = 0;
        for (int i = 0; i < inputs.size(); i++) {

            char[] inputUp = null;
            if (i - 1 >= 0) {
                inputUp = inputs.get(i - 1).toCharArray();
            }

            char[] mainInput = inputs.get(i).toCharArray();

            char[] inputDown = null;
            if (i + 1 < inputs.size()) {
                inputDown = inputs.get(i + 1).toCharArray();
            }

            StringBuilder numberBuilder = new StringBuilder();
            boolean isValidPartNumber = false;

            for (int j = 0; j < mainInput.length; j++) {
                char presentVal = mainInput[j];
                if (presentVal == '.') {
                    if (!numberBuilder.isEmpty() && isValidPartNumber) {
                        totalPartNumber = totalPartNumber + (Integer.valueOf(numberBuilder.toString()));
                    }
                    numberBuilder.delete(0, numberBuilder.length());
                    isValidPartNumber = false;
                } else if (Character.isDigit(presentVal)) {
                    numberBuilder.append(presentVal);
                    if (isAdjacentSymbol(inputUp, j) || isAdjacentSymbol(inputDown, j) || isAdjacentSymbol(mainInput, j)) {
                        isValidPartNumber = true;
                    }
                } else {
                    if (!numberBuilder.isEmpty() && isValidPartNumber) {
                        totalPartNumber = totalPartNumber + (Integer.valueOf(numberBuilder.toString()));
                    }
                    numberBuilder.delete(0, numberBuilder.length());
                    isValidPartNumber = false;
                }
            }
            if (!numberBuilder.isEmpty() && isValidPartNumber) {
                totalPartNumber = totalPartNumber + (Integer.valueOf(numberBuilder.toString()));
            }
        }
        System.out.println(totalPartNumber);
    }

    private static boolean isAdjacentSymbol(char[] inputToCheck, int pos) {

        if (inputToCheck != null) {
            int bf = pos - 1;
            int af = pos + 1;
            if (bf >= 0) {
                if (!Character.isDigit(inputToCheck[bf]) && dot != inputToCheck[bf]) {
                    return true;
                }
            }
            if (af < inputToCheck.length) {
                if (!Character.isDigit(inputToCheck[af]) && dot != inputToCheck[af]) {
                    return true;
                }
            }
            if (!Character.isDigit(inputToCheck[pos]) && dot != inputToCheck[pos]) {
                return true;
            }
        }

        return false;
    }
}
