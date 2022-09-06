package BJ.기본문제.baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<String>> question = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            question.add(new ArrayList<>());
            String[] s = br.readLine().split(" ");

            question.get(i).add(s[0]);
            question.get(i).add(s[1]);
        }

        for (ArrayList<String> strings : question) {
            int count = Integer.parseInt(strings.get(0));
            String str = strings.get(1);
            String result = "";

            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < count; j++) {
                    result += str.charAt(i);
                }
            }

            results.add(result);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}
