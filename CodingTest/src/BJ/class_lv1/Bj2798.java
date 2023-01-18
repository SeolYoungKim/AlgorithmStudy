package BJ.class_lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2798 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] numbers = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            int result = Integer.MIN_VALUE;
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    for (int k = j + 1; k < numbers.length; k++) {
                        int sum = numbers[i] + numbers[j] + numbers[k];
                        if (sum <= m) {
                            result = Math.max(result, sum);
                        }
                    }
                }
            }

            System.out.println(result);
        }
    }
}
