package chapter_01.data_structure._02_two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1253 "좋은 수 구하기"
 */
public class _03_Two_Pointer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int count = 0;
        for (int k = 0; k < n; k++) {
            if (n < 3) {
                break;
            }

            int i = 0;
            int j = n - 1;

            while (i < j) {
                int sum = numbers[i] + numbers[j];
                int num = numbers[k];

                if (sum == num) {
                    if (i != k && j != k) {
                        count++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else {
                        j--;
                    }
                } else if (sum < num) {
                    i++;
                } else {
                    j--;
                }

            }
        }

        System.out.println(count);
    }
}
