package chapter_01.sort._03_insert_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 11399 "ATM 인출 시간 계산하기"
 */
public class _01_InsertSort {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            // 삽입 정렬 구현해서 풀어보기
            // 3 1 4 3 2
            int idx = 1;
            while (idx < n) {
                int currNum = numbers[idx];
                for (int i = idx - 1; i > -1; i--) {
                    int leftNum = numbers[i];
                    if (currNum < leftNum) {
                        numbers[i + 1] = leftNum;
                    } else {
                        numbers[i + 1] = currNum;
                        break;
                    }

                    if (i == 0) {
                        numbers[i] = currNum;
                    }
                }

                idx++;
            }

            System.out.println(Arrays.toString(numbers));
        }
    }



    // 난 이걸로 걍 풀음
    void myMethod() {
        int n = Integer.parseInt("5");
        StringTokenizer st = new StringTokenizer("3 1 4 3 2");

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        int[] cumulativeSum = new int[n];
        cumulativeSum[0] = numbers[0];
        for (int i = 1; i < n; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + numbers[i];
        }

        System.out.println(Arrays.stream(cumulativeSum).sum());
    }
}
