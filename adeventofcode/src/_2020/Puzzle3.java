package _2020;

import java.util.Arrays;
import java.util.List;

public class Puzzle3 {
    public static void main(String[] args) {
        List<String> input = Arrays.asList(".....#....#...#.#..........#...",
                "...#.................#.........",
                "......#...#.#.#.....#..#.....#.",
                ".........#.#.............##....",
                "#..####..#..#.##.....#.........",
                "...#........#..##...........#..",
                "..##.#.#..#....#..#......#.#...",
                ".......#.##....#.....###....#.#",
                ".#..#...#......#..#....##.#....",
                "...#...............#.#.....#...",
                "..#............#..#.........#.#",
                "#.#.#.............##.#......#..",
                "#...#..............##...#.#....",
                "...#....#................#.#..#",
                "..#.#..#.#.#..#.....#.........#",
                "#.............#..#..........#..",
                ".#...#.#........###.#....#...#.",
                "#......#....#.#..#.##..#.......",
                ".##......###.#......#..##...#..",
                "#..#....#........#......#.#....",
                ".#..................#.....#.###",
                ".#......#.#.#.....#...#.#......",
                "....#.............#.#..........",
                "....#..#.#........#..###.......",
                ".....#....#...#........#.......",
                "...........#.###....##.......#.",
                "....#...........#.#..#...#.....",
                "...........#.....#.#...........",
                ".....#........#.....#.#..#....#",
                "#.#......#.......#.......#.....",
                "..........#.............#.#.#..",
                "#...#..........#....#....#.....",
                ".#.#......#..##...#.....#...##.",
                ".#....#...#.#.......#.#........",
                "....#....##.##...#.............",
                "#...#....#..#.........#........",
                "...#.....#.#...#.......#..#....",
                "#.......#...#....##........#..#",
                "####........#........#....#.#..",
                "............##..........#......",
                ".......#.....#.#.#.##..#...#...",
                "..........#....#...##.........#",
                "..##..####.......##......#.##..",
                ".....#.#......##...#..#...#....",
                "....#.#.#.........#........#...",
                "...........###...#.........##..",
                ".......#.#....#......#.##...##.",
                ".................#...##.#...##.",
                ".......#.......#..#.#..........",
                ".#....#..#....#........#.......",
                "...............#.##..#...##..#.",
                ".###.#....#......#...#.#.....#.",
                ".#.....##.......#.......#......",
                "....#..#.....#.....#...........",
                ".......#....#.................#",
                ".......#.##...#...#......#.....",
                ".#.....#...####.............#..",
                "......#.........#..........#...",
                ".........#....#....#........###",
                "....#.........#......##.....#..",
                "....#........##...##.....##...#",
                ".#..#....#..........#...#.###.#",
                "#..#......#...#........#.......",
                "...#.........................#.",
                ".............#........#........",
                ".......#.#.#.....##.....#..#...",
                "..##..##.........#.............",
                ".#...#..#......#...##..##..###.",
                ".....#....#...#...##.##........",
                ".#.#..#...........#..#..#......",
                "##..#...#..#...##..#....#......",
                "...#...#...#.........#....###..",
                "...##..#....#.#.#.......#...#..",
                "..#.#.....#..#....#..##.......#",
                ".....#.#.....#......#....#.#...",
                ".......##....#.....#...#.....#.",
                "..##..#.................#.#....",
                "..............##....##.#..##...",
                ".#..#.....#....#.#.#...........",
                "......#.#.#..#..#...#.....#..##",
                "..#.........#.#.......###...##.",
                "#.....#...........#.....#.##.#.",
                "#..........#....#....#..#....#.",
                ".#.....#...#.......###......#..",
                "....##..##......#....#....#....",
                ".......#.#.............#....#.#",
                ".#..#.##.##.##....#.#.....##.##",
                "....#..##.#..#.............##..",
                "....#...........#...#....#..#..",
                "...........#..#....#....##.#.##",
                "......#....#....#.....#......#.",
                ".##.##....#.....#.#......#...#.",
                ".....##.......#.#.#........##..",
                "#..........##..#....#..#.#....#",
                "...#...........................",
                "...#..#...#..#.#.#.#.......#.#.",
                ".....#.........#..###..........",
                "...#.#......##....#......#..###",
                "#..............#....#.......#..",
                ".........##......###..###......",
                "..#......##...........#.##.....",
                "#.#..#......#...##.............",
                "......#.#.............#....#..#",
                "#.....##..#.#.................#",
                "..##....#.....#....#.....###...",
                ".#.#.##.....#..................",
                ".#......#.#.#.....#..#....#....",
                "..#.#.....##.#...#..#.#.##.....",
                "..#.#..#......##.#.#..........#",
                ".......##.....#..#...#....##.#.",
                "...#.....#..........#..........",
                "......................##......#",
                "...###.........##.........#....",
                "....#..................#.....#.",
                ".##..#.............#........##.",
                "....#....#...###..........#....",
                ".....#.#..........###..........",
                "..#......##......#.#.##.#..#...",
                "##...........#.#..#.....#..#...",
                ".........#......#..........#.#.",
                "...#.##.#..#..###..#...........",
                "....##.#.##...........#.....##.",
                "....#...................###....",
                "#.......#......#......#.....#..",
                "#..........##..................",
                "...#..#.#....#..#.........##.#.",
                "......#...##.#...............#.",
                ".........#....#.#...#..#..#....",
                "...#......###..#......#.....#.#",
                "#..###.#.............#.........",
                "......#...........#............",
                "..#..#.##.....#......#.#..#...#",
                ".........#..............#......",
                "........#.....#..#...#.....#..#",
                ".....................#........#",
                ".##.......##...#.###.........#.",
                ".#...#.......#.#....##....#....",
                "........#......#...........#.#.",
                "....#......##...#.....#...#...#",
                "..#.........#.#...............#",
                "....#.....#......#.............",
                ".............##.....#....#.....",
                "........#......#.#.....#....#..",
                "#.........#...#......#....#...#",
                ".#........###...#.#.#...#....#.",
                ".###...........#..#............",
                "....##.........#..#...##.#..###",
                ".####..#.#...............##.#..",
                "#.....#...#....#.......##....#.",
                "..#.....##...##.#...#..#.......",
                "..#.###.......#.....#.......#..",
                "...........#.......#....##....#",
                "..#...#....##........###......#",
                "...#..#..............#...#.....",
                "##.#.............#....##.#..##.",
                "##.#..#..............#.#.......",
                ".......#....#....##............",
                ".##..##.#..........#.#...#.#...",
                ".........##.......##...#...#...",
                "............#...##....#...#....",
                "........#...#..#...#.##......#.",
                "..#...#.#.........#.#....#.....",
                "..#...#.#..#.......#.#.........",
                ".......#.....#...#.#..###....#.",
                ".#......#.#....#.#.####....#...",
                ".......##..#......#...#......##",
                "#####.....#........#.#.......#.",
                ".....#...#..#...#.#.....#..#...",
                "....#...#....##.....##....#.#..",
                ".#..#......#.####.....#....#..#",
                "...#.......#..#.....##........#",
                ".#.....#.#.#.....##...#..#.....",
                ".............#...#..#.....#....",
                "...#.....##.......#...##..#...#",
                "..#.............#...#..#..##...",
                "...#........#........#...#...#.",
                "##..........#.#.#.............#",
                "....#....#..............#..#...",
                "....#..####..##....#.......#.#.",
                ".#..#.....##....#.#.....#...#..",
                "#............##..#..#.#......#.",
                "....#..........##..#...........",
                "..#.##.#.......#...#.##....#...",
                "....#.#.............#.#.##....#",
                "...#..#.#.#......#..#....#....#",
                ".............#...........#..#..",
                "#.............##.......#..###..",
                "..##....#.#.#...#...#....#...#.",
                "##.......####........##..#.....",
                ".###..#..#..#..#...#.#.........",
                "............#............#.....",
                "#...#.....#.#.##.##...#.......#",
                "#........#....#...#.........#..",
                "#....#.#......#.............#..",
                "....#............#......##...#.",
                ".......#........#..#.......#..#",
                "#.#...#.#.#..#..#........#....#",
                "#.#.##...........#.....#.....#.",
                ".#...##.#..#...................",
                "###...#.#.....................#",
                ".#....##...##.#....#..#........",
                "........###...#.#....##...#..##",
                "...#..#..........###..#.......#",
                "..#..##.............#.....#....",
                "....##..#..............#.......",
                "...##...##.#....#.#...#...#.#.#",
                "..#..........#.....##........#.",
                ".#.#.....#......#..#....#......",
                "...##.#....#.......#......#....",
                "...##..#........##......#..##..",
                "#..###...#...........#.#.......",
                "..##...#...#.#.#...#.#.....#...",
                "..#.....##.#....#.....#..#.....",
                "..#.#......#.......#...........",
                "....##......##.............#..#",
                ".......#.........##...#..#...#.",
                ".#........#.##.#.....#.#.......",
                "#..#...#..#.....##...........#.",
                "..##..............#....#.......",
                ".#..#....#.#...........#..##.#.",
                "#....#..###..........#...#.....",
                ".......#...##........#.#...###.",
                "....#..#......##......#.....#..",
                ".#..##..#..#......#......#.##..",
                "....#.#...........#..#.#.##.#..",
                ".....#......#.....#.....#..#...",
                "..........#...........#...##...",
                "#..#.#.#..#....#.....##......##",
                "..#.....#.....#................",
                "...#.#..##.........#..#..##....",
                ".#.....##..#.#.#.#.....#.......",
                "...........##...#..............",
                "...#.#....##..#.............###",
                "...#.#...........#.........#...",
                "#.....#.....##..#.#.#.#....#...",
                "##..................##.##......",
                "......#.....#....#.....#..#...#",
                ".............#.......#....#..##",
                ".#..#.##..#..#.........##...#..",
                "..#.#....#........#....#....##.",
                ".#.#.#.#.#.......#.......#..#..",
                "#.....#..##..#.........#.......",
                ".............#.#..............#",
                ".........#......#....#.#......#",
                ".........#.#...##..#.#.........",
                "...........#..........#........",
                ".......#...#...#......#..#.....",
                "#.....#...............#.....#.#",
                "..#....#..........#.#...#..#...",
                "#....##..#..#.....#.#..#.#.....",
                ".#....#..###............##.....",
                "......#.##...........#....#..#.",
                "...#........##....#...#...#....",
                "..#.#.#.....#..#.#..........##.",
                "..................#...........#",
                "##........#.#......#.#.......#.",
                "......#..#.............##......",
                ".#..###..#...###......#....#..#",
                "..#...........#...#...##..#...#",
                "..#..........#..............#..",
                ".....#.........................",
                "..#.#..##...........##...#.....",
                "...........#......##.....##....",
                "......#.......#................",
                ".........#.......#.#...........",
                "#......#...#........##.....##..",
                "...#.....#....#..#.....#.......",
                "....#.#......#...#..#.##.##...#",
                "..#..#.#.....#...#...........#.",
                ".#....##.####.....#..........##",
                "...##.##.....##..###...#.......",
                ".......#.#...#....#.......#..#.",
                ".#..#.###.#.............#......",
                ".###.........####..#...........",
                "#..#.#.###.....#.......#.......",
                ".#.....#.....#.....#.........#.",
                "..#...#......#.......##.###....",
                ".......##.............##.#.....",
                ".....................#.....##.#",
                "##.#...#........#..##........#.",
                "...#..........#.#.#..#......###",
                ".#....#.#.#..........##........",
                "....#....####....#.#....#..#.#.",
                "..#.........#....##..........##",
                "...##.#.......##.#.......#.#...",
                "........#..#......#...#.#.....#",
                ".....##............#.#.......#.",
                ".........##...##..#.....#..#...",
                "#...#....#........#...#....##.#",
                "..#.....#..........#...##.....#",
                ".##..#.........#...........#...",
                ".....##.#.#.#.#..#...#.....#.#.",
                ".#..#..##.........#.......#...#",
                "#....#.....#...#....#.........#",
                "...#..#.......#.........#......",
                ".#....##..#......##.#.#......#.",
                "....##.##...........#...#......",
                "..#.#....#.##...#......#.......",
                "...#........#.............#....",
                "...##....................#.###.",
                ".#.......#.........#......##...",
                "....#..#..............#....#...",
                "....##.#............#..........",
                ".#...#....#...##..........#....",
                "....#............#.....#.......",
                ".......#........#..............",
                "....#.#....#.#..#..#...........",
                "......................#.#......",
                "#......##.....#..#.......##....",
                "...#........#........#.#...##..",
                "##.#....##....#................",
                "#..#....#..............#.##....",
                "......#........#...........#...",
                "#....##.##...#...#..#...##.....",
                "............#............#..#..",
                "#....#...#..#..#.#...........#.",
                ".......#..........#..........##",
                ".....#......#....##.#..........",
                ".#....#....#....#....#..#...#..",
                ".....###....#...#.#.#........#.",
                ".......#...#..........##..#...#",
                "..##........................##.",
                ".....#....#..............#....#");
        int pos3 = 0;
        int pos1 = 0;
        int pos5 = 0;
        int pos7 = 0;
        int pos12 = 0;
        int count3 = 0;
        int count1 = 0;
        int count5 = 0;
        int count7 = 0;
        int count12 = 0;
        for (int i = 1; i < input.size(); i++) {
            char val = '\0';

            pos3 = pos3 + 3;
            if (pos3 > 30) {
                pos3 = pos3 - 31;
            }
            val = input.get(i).charAt(pos3);
            if(val == '#'){
                count3++;
            }

            pos1 = pos1 + 1;
            if (pos1 > 30) {
                pos1 = pos1 - 31;
            }
            val = input.get(i).charAt(pos1);
            if(val == '#'){
                count1++;
            }

            pos5 = pos5 + 5;
            if (pos5 > 30) {
                pos5 = pos5 - 31;
            }
            val = input.get(i).charAt(pos5);
            if(val == '#'){
                count5++;
            }

            pos7 = pos7 + 7;
            if (pos7 > 30) {
                pos7 = pos7 - 31;
            }
            val = input.get(i).charAt(pos7);
            if(val == '#'){
                count7++;
            }

            if(i%2==0) {
                pos12 = pos12 + 1;
                if (pos12 > 30) {
                    pos12 = pos12 - 31;
                }
                val = input.get(i).charAt(pos12);
                if (val == '#') {
                    count12++;
                }
            }
        }
        System.out.println(count3);
        System.out.println(count1);
        System.out.println(count5);
        System.out.println(count7);
        System.out.println(count12);


    }
}
