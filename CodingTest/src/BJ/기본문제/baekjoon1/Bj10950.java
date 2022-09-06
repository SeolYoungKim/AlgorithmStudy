package BJ.기본문제.baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arrA = new int[t];
        int[] arrB = new int[t];

        for (int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");

            arrA[i] = Integer.parseInt(s[0]);
            arrB[i] = Integer.parseInt(s[1]);
        }

        for (int i = 0; i < t; i++) {
            System.out.println(arrA[i] + arrB[i]);
        }
    }
}
