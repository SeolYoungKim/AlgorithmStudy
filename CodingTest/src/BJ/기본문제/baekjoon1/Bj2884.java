package BJ.기본문제.baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int h = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        if (0 <= h && h <= 23 && 0 <= m && m <= 59) {
            if (h == 0) {
                h = 24;
            }

            int result = m - 45;

            if (result < 0) {
                h -= 1;
                m = 60 + result;
            } else {
                m = result;
            }
        }

        if (h == 24) {
            h = 0;
        }

        System.out.println(h + " " + m);

    }
}
