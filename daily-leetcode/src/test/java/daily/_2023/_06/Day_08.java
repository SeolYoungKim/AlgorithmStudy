package daily._2023._06;

import java.util.Arrays;

public class Day_08 {
    public int countNegatives(int[][] grid) {
        return (int) Arrays.stream(grid)
                .flatMapToInt(Arrays::stream)
                .filter(num -> num < 0)
                .count();
    }
}
