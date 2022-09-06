package BJ.기본문제.baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);
        int count;

        // x = 판매 대수
        // 손실 : y = bx + a
        // 이득 : y = cx

        // 손익 분기점
        // cx = bx + a
        // (c - b) x = a
        // x = a / (c - b)

        if (b > c || c == b) {
            count = -1;
        } else {
            count = (a / (c - b)) + 1;  // 손익분기점 + 1 == 이득
        }

        System.out.println(count);

    }
}
