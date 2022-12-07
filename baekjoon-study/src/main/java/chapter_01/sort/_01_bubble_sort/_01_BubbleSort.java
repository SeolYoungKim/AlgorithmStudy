package chapter_01.sort._01_bubble_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 백준 2750번 "수 정렬하기 1"
 */
public class _01_BubbleSort {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(br.readLine());
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    int prev = numbers[j];
                    int next = numbers[j + 1];

                    if (prev < next) {
                        continue;
                    }

                    if (prev > next) {  // 크면 swap
                        numbers[j] = next;
                        numbers[j + 1] = prev;
                    }
                }
            }

            for (int number : numbers) {
                bw.write(number + "\n");
            }

            bw.flush();
        }
    }

}
