package chapter_01.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class _03_Greedy {
    public static void main(String[] args) throws IOException {
        shortMethod();
    }

    static void shortMethod() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 1; i < n + 1; i++) {
            ans[i] = ans[i - 1] + arr[i - 1];
            if (i > 1) {
                ans[i] = Math.max(ans[i], ans[i - 2] + (arr[i - 2] * arr[i - 1]));
            }
        }
        System.out.println(ans[n]);
    }

    static void myMethod() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            Queue<Integer> positiveQueue = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<Integer> negativeOrZeroQueue = new PriorityQueue<>(Comparator.naturalOrder());
            for (int i = 0; i < n; i++) {
                int input = Integer.parseInt(br.readLine());
                if (input <= 0) {
                    negativeOrZeroQueue.offer(input);
                } else {
                    positiveQueue.offer(input);
                }
            }

            int result = 0;
            // 가장 큰것 부터 확인
            while (!positiveQueue.isEmpty()) {
                Integer first = positiveQueue.poll();
                if (first == 1) {
                    result++;
                    continue;
                }

                if (positiveQueue.peek() == null) {
                    result += first;
                    break;
                }

                if (positiveQueue.peek() == 1) {
                    result += first;
                    continue;
                }

                Integer second = positiveQueue.poll();
                result += (first * second);
            }

            // 가장 작은것 부터 확인
            while (!negativeOrZeroQueue.isEmpty()) {
                Integer first = negativeOrZeroQueue.poll();
                Integer second = negativeOrZeroQueue.poll();

                if (second == null) {
                    result += first;
                    continue;
                }

                result += (first * second);
            }

            System.out.println(result);
        }
    }
}
