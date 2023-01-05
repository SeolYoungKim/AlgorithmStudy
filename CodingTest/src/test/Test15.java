package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test15 {
    public static void main(String[] args) {
        int[][] v = {{1, 1}, {2, 2}, {1, 2}};
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        for (int[] numbers : v) {
            xMap.put(numbers[0], xMap.getOrDefault(numbers[0], 0) + 1);
            yMap.put(numbers[1], yMap.getOrDefault(numbers[1], 0) + 1);
        }

        int x = 0, y = 0;
        for (Map.Entry<Integer, Integer> entry : xMap.entrySet()) {
            if (entry.getValue() != 2) {
                x = entry.getKey();
            }
        }

        for (Map.Entry<Integer, Integer> entry : yMap.entrySet()) {
            if (entry.getValue() != 2) {
                y = entry.getKey();
            }
        }
        int[] ints = {x, y};
        System.out.println(Arrays.toString(ints));
    }
}
