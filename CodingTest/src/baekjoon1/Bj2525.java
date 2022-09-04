package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        int c = Integer.parseInt(br.readLine());

        if (0 <= a && a <= 23 && 0 <= b && b <= 59 && 0 <= c && c <= 1000) {
            b = b + c;

            while (b >= 60) {
                a += 1;
                b -= 60;
            }


            if (a > 23) {
                a -= 24;
            }

            if (a == 24) {
                a = 0;
            }


            System.out.println(a + " " + b);

        }

    }
}
