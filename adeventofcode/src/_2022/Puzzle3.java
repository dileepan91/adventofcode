package _2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Puzzle3 {

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2022/Puzzle3Input.txt"));
        int totalVal = 0;

        Map<Integer, Set<Character>> block3 = new HashMap<>();
        int rc = 1;
        for(String input: inputs) {
            char[] inChar = input.toCharArray();

            Set<Character> content1 = new HashSet<>();
            for(int i=0;i<input.length();i++){
                content1.add(inChar[i]);
            }

            block3.put(rc, content1);


            if(rc == 3) {
                Map<Character, Integer> occ = new HashMap<>();

                Set<Character> con1 = block3.get(1);
                Set<Character> con2 = block3.get(2);
                Set<Character> con3 = block3.get(3);

                for(Character con : con2) {
                    if(!con1.add(con)){
                        if(occ.containsKey(con)) {
                            int x = occ.get(con);
                            x++;
                            occ.replace(con, x);
                        } else {
                            occ.put(con, 1);
                        }
                    }
                }

                for(Character con : con3) {
                    if(!con1.add(con)){
                        if(occ.containsKey(con)) {
                            int x = occ.get(con);
                            x++;
                            occ.replace(con, x);
                        } else {
                            occ.put(con, 1);
                        }
                    }
                }

                int val = 0;
                Character c2 = null;
                for (Map.Entry<Character, Integer> entry : occ.entrySet()) {
                    if (entry.getValue().equals(2)) {
                        c2 = entry.getKey();
                    }
                }

                int n = (int)c2;
                if(Character.isLowerCase(c2)) {
                    val = n-96;
                } else {
                    val = n-38;
                }
                totalVal = totalVal + val;
                rc =1;
                block3.clear();
            } else{
                rc++;
            }


        }
        System.out.println(totalVal);
    }

    public static void main1(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2022/Puzzle3Input.txt"));
        int totalVal = 0;
        for(String input: inputs) {
            int half = input.length()/2;
            char[] inChar = input.toCharArray();
            Set<Character> content1 = new HashSet<>();
            for(int i=0;i<half;i++){
                content1.add(inChar[i]);
            }

            Set<Character> content2 = new HashSet<>();
            for(int j=half;j<input.length();j++){
                content2.add(inChar[j]);
            }

            for(Character c2: content2){
                if(!content1.add(c2)) {
                    int val = 0;
                    int n = (int)c2;
                    if(Character.isLowerCase(c2)) {
                        val = n-96;
                    } else {
                        val = n-38;
                    }
                    totalVal = totalVal + val;
                    break;
                }
            }
        }
        System.out.println(totalVal);
    }
}
