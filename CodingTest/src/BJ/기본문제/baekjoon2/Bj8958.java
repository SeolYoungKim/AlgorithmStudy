package BJ.기본문제.baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count;
        int result;

        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            strings.add(br.readLine());
        }

        for (String string : strings) {
            count = 0;
            result = 0;

            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == 'O') {
                    count++;
                    result += count;
                } else {
                    count = 0;
                }
            }

            results.add(result);
        }

        for (Integer integer : results) {
            System.out.println(integer);
        }
    }
}
