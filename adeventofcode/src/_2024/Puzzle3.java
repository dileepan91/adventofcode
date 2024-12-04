package _2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle3 {

    public static void main1(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2024/Puzzle3Input.txt"));
        String result = String.join("", inputs);
        long answer = 0;
        String[] muls = result.split("mul");
        for (String mul : muls) {
            answer = addUpMuls(mul, answer);
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2024/Puzzle3Input.txt"));

        long answer = 0;
        String result = String.join("", inputs);

        int firstIndexOfDont = result.indexOf("don't()");

        String inputMuls = result.substring(0, firstIndexOfDont);
        String remaining = result.substring(firstIndexOfDont);

        String[] muls = inputMuls.split("mul");
        for (String mul : muls) {
            answer = addUpMuls(mul, answer);
        }

        String[] donts = remaining.split("don't()");
        for (String dont : donts) {
            String[] dos = dont.split("do()");
            for (int i = 1; i < dos.length; i++) {
                String[] dosmuls = dos[i].split("mul");
                for (String dosmul : dosmuls) {
                    answer = addUpMuls(dosmul, answer);
                }
            }
        }

        System.out.println(answer);
    }

    private static long addUpMuls(String mul, long answer) {
        if (mul.startsWith("(") && mul.contains(",") && mul.contains(")")) {
            long a, b;
            try {
                String as = mul.substring(mul.indexOf("(") + 1, mul.indexOf(","));
                a = Long.parseLong(as);

                String bs = mul.substring(mul.indexOf(",") + 1, mul.indexOf(")"));
                b = Long.parseLong(bs);

                answer += a * b;
            } catch (NumberFormatException e) {
                // do nothing
            }

        }
        return answer;
    }
}
