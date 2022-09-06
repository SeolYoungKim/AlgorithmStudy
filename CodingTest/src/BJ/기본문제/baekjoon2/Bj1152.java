package BJ.기본문제.baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        ArrayList<String> results = new ArrayList<>();

        for (String s : split) {
            if (!s.isEmpty()) {
                results.add(s);
            }
        }

        System.out.println(results.size());

    }
}
