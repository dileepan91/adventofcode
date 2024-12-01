package _2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle1 {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("adeventofcode/src/_2021/Puzzle1Input.txt"));

        //part 1
        int increased = 0;
        for(int i=1;i<input.size();i++){
            if(Integer.valueOf(input.get(i-1)).compareTo(Integer.valueOf(input.get(i))) < 0) {
                increased++;
            }
        }
        System.out.println(increased);

        //part 2
        int increasedPart2 = 0;
        Integer temp = Integer.valueOf(input.get(1)) + Integer.valueOf(input.get(2));
        Integer previous = temp + Integer.valueOf(input.get(0));
        for(int i=3;i<input.size();i++){

            int current = temp + Integer.valueOf(input.get(i));
            if(previous < current) {
                increasedPart2++;
            }
            temp = current - Integer.valueOf(input.get(i-2));
            previous = current;
        }

        System.out.println(increasedPart2);
    }
}
