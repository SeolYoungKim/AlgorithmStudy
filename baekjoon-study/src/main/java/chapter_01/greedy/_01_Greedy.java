package chapter_01.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _01_Greedy {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }

            int result = 0;

            outer:
            while (k != 0) {
                for (int i = n - 1; i > -1; i--) {
                    if (coins[i] <= k) {
                        int changes = k % coins[i];
                        int coinCount = k / coins[i];
                        result += coinCount;

                        k = changes;
                    }

                    if (k == 0) {
                        break outer;
                    }
                }
            }

            System.out.println(result);
        }
    }
}
