package BJ.기본문제.baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        ArrayList<Integer> scores = new ArrayList<>();
        ArrayList<Double> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            scores.add(Integer.parseInt(s[i]));
        }

        for (Integer score : scores) {
            max = Math.max(max, score);
        }

        for (Integer score : scores) {
            result.add((double) score / max * 100);
        }

        double addAll = 0;

        for (Double aDouble : result) {
            addAll += aDouble;
        }

        System.out.println(addAll / n);

    }
}
