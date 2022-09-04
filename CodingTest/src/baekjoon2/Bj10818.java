package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            integers.add(Integer.parseInt(s[i]));
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Integer integer : integers) {
            min = Math.min(min, integer);
            max = Math.max(max, integer);
        }

        System.out.println(min + " " + max);
    }
}
