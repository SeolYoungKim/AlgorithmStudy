package BJ.class_lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1436 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            long[] numbers = new long[n];
            numbers[0] = 666;

            long destroyNumber = 666;
            int idx = 1;
            while (idx < n) {
                destroyNumber++;
                String strNum = String.valueOf(destroyNumber);
                if (strNum.contains("666")) {
                    numbers[idx] = destroyNumber;
                    idx++;
                }
            }

            System.out.println(numbers[n - 1]);
        }
    }
}
