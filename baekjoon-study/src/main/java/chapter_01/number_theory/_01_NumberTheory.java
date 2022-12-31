package chapter_01.number_theory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 백준 1929 "소수 구하기"
 */
public class _01_NumberTheory {
    static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            isNotPrime = new boolean[n + 1];
            isNotPrime[0] = true;
            isNotPrime[1] = true;

            checkPrime(n);

            for (int i = m; i <= n; i++) {
                if (!isNotPrime[i]) {
                    bw.write(i + "\n");
                }
            }

            bw.flush();
        }
    }

    static void checkPrime(int number) {
        if (number < 2) {
            return;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i * i; j < isNotPrime.length; j += i) {
                isNotPrime[j] = true;
            }
        }
    }
}
