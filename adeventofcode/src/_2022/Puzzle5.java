package _2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Puzzle5 {

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2022/Puzzle5Input.txt"));

        List<Stack<String>> stackList = buildInputStack();

        for (int i = 10; i < inputs.size(); i++) {
            String input = inputs.get(i);
            String[] inputArray = input.split(" ");

            int toMove = Integer.valueOf(inputArray[1]);
            int from = Integer.valueOf(inputArray[3]);
            int to = Integer.valueOf(inputArray[5]);

            Stack<String> fromStack = stackList.get(from - 1);
            Stack<String> toStack = stackList.get(to - 1);

            Stack<String> popedStack = new Stack<>();
            for (int j = 0; j < toMove; j++) {
                popedStack.push(fromStack.pop());
            }

            while(!popedStack.empty()) {
                toStack.push(popedStack.pop());
            }

        }

        String result = getPeekOfAllStack(stackList);

        System.out.println(result);
    }


    public static void main1(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2022/Puzzle5Input.txt"));

        List<Stack<String>> stackList = buildInputStack();

        for (int i = 10; i < inputs.size(); i++) {
            String input = inputs.get(i);
            String[] inputArray = input.split(" ");

            int toMove = Integer.valueOf(inputArray[1]);
            int from = Integer.valueOf(inputArray[3]);
            int to = Integer.valueOf(inputArray[5]);

            Stack<String> fromStack = stackList.get(from - 1);
            Stack<String> toStack = stackList.get(to - 1);

            for (int j = 0; j < toMove; j++) {
                String poped = fromStack.pop();
                toStack.push(poped);
            }
        }

        String result = getPeekOfAllStack(stackList);

        System.out.println(result);
    }

    private static String getPeekOfAllStack(List<Stack<String>> stackList) {
        String result = "";
        for (Stack<String> stack : stackList) {
            result = result + stack.peek();
        }
        return result;
    }

    private static List<Stack<String>> buildInputStack() {
        Stack<String> stack1 = new Stack<>();
        stack1.addAll(Arrays.asList("J", "H", "P", "M", "S", "F", "N", "V"));

        Stack<String> stack2 = new Stack<>();
        stack2.addAll(Arrays.asList("S", "R", "L", "M", "J", "D", "Q"));

        Stack<String> stack3 = new Stack<>();
        stack3.addAll(Arrays.asList("N", "Q", "D", "H", "C", "S", "W", "B"));

        Stack<String> stack4 = new Stack<>();
        stack4.addAll(Arrays.asList("R", "S", "C", "L"));

        Stack<String> stack5 = new Stack<>();
        stack5.addAll(Arrays.asList("M", "V", "T", "P", "F", "B"));

        Stack<String> stack6 = new Stack<>();
        stack6.addAll(Arrays.asList("T", "R", "Q", "N", "C"));

        Stack<String> stack7 = new Stack<>();
        stack7.addAll(Arrays.asList("G", "V", "R"));

        Stack<String> stack8 = new Stack<>();
        stack8.addAll(Arrays.asList("C", "Z", "S", "P", "D", "L", "R"));

        Stack<String> stack9 = new Stack<>();
        stack9.addAll(Arrays.asList("D", "S", "J", "V", "G", "P", "B", "F"));

        List<Stack<String>> stackList = new ArrayList<>();

        stackList.add(stack1);
        stackList.add(stack2);
        stackList.add(stack3);
        stackList.add(stack4);
        stackList.add(stack5);
        stackList.add(stack6);
        stackList.add(stack7);
        stackList.add(stack8);
        stackList.add(stack9);

        return stackList;
    }
}
