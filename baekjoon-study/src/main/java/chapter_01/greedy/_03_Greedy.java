package chapter_01.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _03_Greedy {
    public static void main(String[] args) throws IOException {
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
