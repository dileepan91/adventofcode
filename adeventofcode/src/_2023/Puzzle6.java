package _2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle6 {

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2023/Puzzle6Input.txt"));
        String[] times = inputs.get(0).split("     ");
        String[] distances = inputs.get(1).split("   ");
        long numOfWays = 1;
        for (int i = 1; i < times.length; i++) {
            long time = Integer.valueOf(times[i].trim());
            long distance = Long.valueOf(distances[i].trim());
            long possibility = 0;
            for (int j = 1; j <= time / 2; j++) {
                long distanceTravelled = (time - j) * j;
                if (distanceTravelled > distance) {
                    possibility =  (time/2) - (j - 1);
                    break;
                }
            }
            if (possibility > 0) {
                possibility = possibility * 2;
                if (time % 2 == 0) {
                    possibility--;
                }
                numOfWays = numOfWays * possibility;
            }
        }
        System.out.println(numOfWays);
    }
}
