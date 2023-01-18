package BJ.class_lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1978 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            // 1000개 까지의 소수를 구한다
            boolean[] isNotPrime = new boolean[1001];
            isNotPrime[0] = isNotPrime[1] = true;
            for (int i = 2; i <= Math.sqrt(1000); i++) {
                for (int j = i * i; j < isNotPrime.length; j += i) {
                    isNotPrime[j] = true;
                }
            }

            int count = 0;
            String[] numbers = br.readLine().split(" ");
            for (String number : numbers) {
                int intNum = Integer.parseInt(number);
                if (!isNotPrime[intNum]) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
