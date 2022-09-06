package BJ.기본문제.baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int tens;
        int units;
        int temp;

        int count = 0;

        int result = n;

        while (true) {
            if (result < 10) {
                tens = 0;
                units = result;
            } else {
                tens = result / 10;
                units = result % 10;
            }

            temp = tens + units;
            result = (temp % 10) + (units * 10);

            count++;

            if (n == result) {
                break;
            }
        }

        System.out.println(count);
    }
}
