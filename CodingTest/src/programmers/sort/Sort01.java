package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Sort01 {

    public static void main(String[] args) {
        Sort01 sort01 = new Sort01();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3},
        };

        int[] solution = sort01.solution(array, commands);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int[] array, int[][] commands) {
        List<Integer> results = new ArrayList<>();

        for (int[] command : commands) {
            int from = command[0] - 1;
            int to = command[1] - 1;
            int pick = command[2] - 1;

            int[] ints = IntStream.rangeClosed(from, to)
                    .map(i -> array[i])
                    .sorted()
                    .toArray();

            results.add(ints[pick]);
        }

        return results.stream().mapToInt(i -> i).toArray();
    }
}
