package BJ.기본문제.baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            a.add(Integer.parseInt(s[0]));
            b.add(Integer.parseInt(s[1]));
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Case #%d: %d + %d = %d%n",i + 1, a.get(i), b.get(i), a.get(i) + b.get(i));
        }
    }
}
