package programmers.brute_force;

import java.util.Arrays;

public class BruteForce01 {

    public static void main(String[] args) {
        int[][] sizes = {
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40},
        };

        BruteForce01 bruteForce01 = new BruteForce01();
        int solution = bruteForce01.solution(sizes);
        System.out.println("solution = " + solution);
    }

    public int solution(int[][] sizes) {
        int answer = 0;
        for (int[] size : sizes) {
            int width = size[0];
            int height = size[1];

            if (width < height) {
                size[0] = height;
                size[1] = width;
            }
        }
        int widthMax = Integer.MIN_VALUE;
        int heightMax = Integer.MIN_VALUE;
        for (int[] size : sizes) {
            int width = size[0];
            int height = size[1];

            widthMax = Math.max(widthMax, width);
            heightMax = Math.max(heightMax, height);
        }

        System.out.println(Arrays.deepToString(sizes));
        return widthMax * heightMax;
    }
}
