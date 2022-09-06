package BJ.기본문제.baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());

        if (90 <= i && i <= 100) {
            System.out.println("A");
        } else if (80 <= i && i < 90) {
            System.out.println("B");
        } else if (70 <= i && i < 80) {
            System.out.println("C");
        } else if (60 <= i && i < 70) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
