package BJ.기본문제.baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Bj2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        ArrayList<String> results = new ArrayList<>();

        for (String s : split) {
            String first = String.valueOf(s.charAt(0));
            String second = String.valueOf(s.charAt(1));
            String third = String.valueOf(s.charAt(2));

            String temp = "";
            String result = "";

            temp = first;
            first = third;
            third = temp;

            result = first + second + third;
            results.add(result);
        }

        System.out.println(Collections.max(results));

    }
}
