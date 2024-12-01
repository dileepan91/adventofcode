package _2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle2 {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("adeventofcode/src/_2021/Puzzle2Input.txt"));
        Long horizontal = 0l;
        Long depth = 0l;
        Long aim = 0l;  // part 2
        for(String val: input){
            String[] pos = val.split(" ");
            int xUnit = Integer.valueOf(pos[1]);
            switch (pos[0]) {
                case "forward":
                    horizontal = horizontal + xUnit;
                    depth = depth + (aim*xUnit); // part 2
                    break;
                case "up":
                    //depth = depth - xUnit;  // uncomment for part 1
                    aim = aim - xUnit; // part 2
                    break;
                case "down":
                    //depth = depth + xUnit; // uncomment for part 1
                    aim = aim + xUnit; // part 2
                    break;
            }
        }
        System.out.println(horizontal * depth);
    }

}
