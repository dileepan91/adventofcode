package _2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle1{

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2022/Puzzle1Input.txt"));
        int highCalories[] = {0,0,0};
        int calories = 0;
        for(String input:inputs) {
            if(input.equals("")){
                for(int i=0;i<3;i++){
                    if (calories > highCalories[i]) {
                        for(int j=2;j>i;j--){
                            highCalories[j] = highCalories[j-1];
                        }
                        highCalories[i] = calories;
                        break;
                    }
                }
                calories = 0;
            } else {
                calories = calories + Integer.valueOf(input);
            }
        }
        System.out.println(highCalories[0]+highCalories[1]+highCalories[2]);
    }

    public static void main1(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("src/java/adventofcode2022/Puzzle1Input.txt"));
        int highCalories = 0;
        int calories = 0;
        for(String input:inputs) {
            if(input.equals("")){
                if(calories > highCalories) {
                    highCalories = calories;
                }
                calories = 0;
            } else {
                calories = calories + Integer.valueOf(input);
            }
        }
        System.out.println(highCalories);
    }

}