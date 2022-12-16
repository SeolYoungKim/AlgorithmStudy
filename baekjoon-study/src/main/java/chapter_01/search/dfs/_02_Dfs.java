package chapter_01.search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2023번 "신기한 소수 찾기"
 */
public class _02_Dfs {
    static int n;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            dfs(2, 1);
            dfs(3, 1);
            dfs(5, 1);
            dfs(7, 1);
        }
    }

    static void dfs(int number, int jarisu) {
        if (jarisu == n) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {  // 그 다음 자리수의 숫자가 될 후보 탐색
            if (i % 2 == 0) {
                continue;
            }

            int nextNumber = number * 10 + i;
            if (isPrime(nextNumber)) {  // 소수라면 자릿수를 늘려 다시 판단
                dfs(nextNumber, jarisu + 1);
            }

        }

    }


    static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
