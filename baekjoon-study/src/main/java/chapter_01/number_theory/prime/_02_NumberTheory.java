package chapter_01.number_theory.prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1456번 "거의 소수 구하기"
 */
public class _02_NumberTheory {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            int maxNum = 10_000_000;
            long[] numbers = new long[maxNum + 1];
            for (int i = 0; i < maxNum; i++) {
                numbers[i] = i;
            }

            for (int i = 2; i <= Math.sqrt(maxNum); i++) {
                if (numbers[i] == 0) {
                    continue;
                }

                for (int j = i * i; j < numbers.length; j += i) {
                    numbers[j] = 0;
                }
            }

            int count = 0;
            for (int i = 2; i <= maxNum; i++) {
                if (numbers[i] == 0) {
                    continue;
                }

                long temp = numbers[i];
                while ((double) numbers[i] <= (double) b / temp) {
                    if ((double) numbers[i] >= (double) a / temp) {
                        count++;
                    }

                    temp *= numbers[i];
                }
            }

            System.out.println(count);

        }
    }
}
