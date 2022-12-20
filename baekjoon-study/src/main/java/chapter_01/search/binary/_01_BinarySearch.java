package chapter_01.search.binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1920번 "원하는 정수 찾기"
 */
public class _01_BinarySearch {
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] numbersForSearch = new int[n];
            for (int i = 0; i < m; i++) {
                numbersForSearch[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(numbers);
            for (int value : numbersForSearch) {
                bw.write(binarySearch(value) + "\n");
            }

            bw.flush();
        }
    }

    static int binarySearch(int value) {
        int leftIdx = 0;
        int rightIdx = numbers.length - 1;

        while (leftIdx <= rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            if (value == numbers[midIdx]) {
                return 1;
            }

            if (value < numbers[midIdx]) {
                rightIdx = midIdx - 1;
            }

            if (value > numbers[midIdx]) {
                leftIdx = midIdx + 1;
            }
        }

        return 0;
    }
}
