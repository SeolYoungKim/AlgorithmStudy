package programmers.brute_force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class BruteForce02 {

    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};
        BruteForce02 bruteForce02 = new BruteForce02();
        int[] solution = bruteForce02.solution(answers2);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(int[] answers) {
        int length = answers.length;
        ArrayList<Integer> results = new ArrayList<>();

        int[] giveUp1 = {1, 2, 3, 4, 5};
        int[] giveUp2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] giveUp3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (giveUp1[i % giveUp1.length] == answers[i]) {
                count1++;
            }

            if (giveUp2[i % giveUp2.length] == answers[i]) {
                count2++;
            }

            if (giveUp3[i % giveUp3.length] == answers[i]) {
                count3++;
            }
        }

        int max = Math.max(count1, Math.max(count2, count3));
        if (count1 == max) {
            results.add(1);
        }

        if (count2 == max) {
            results.add(2);
        }

        if (count3 == max) {
            results.add(3);
        }

        return results.stream()
                .mapToInt(result -> result)
                .toArray();
    }
}
