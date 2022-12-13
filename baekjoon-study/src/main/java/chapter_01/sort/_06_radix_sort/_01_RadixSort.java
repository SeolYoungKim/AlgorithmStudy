package chapter_01.sort._06_radix_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _01_RadixSort {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());

            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(br.readLine());
            }

            radixSort(numbers);

            for (int number : numbers) {
                bw.write(number + "\n");
            }

            bw.flush();
        }
    }

    public static void radixSort(int[] numbers) {
        // Queue 10개 마련
        List<Queue<Integer>> queues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            queues.add(new LinkedList<>());
        }

        // 자릿수 별로 순차적으로 분류 해야 됨
        int factor = 1;
        for (int i = 0; i < 5; i++) {
            for (int number : numbers) {
                queues.get((number / factor) % 10).offer(number);
            }

            int idx = 0;
            for (Queue<Integer> queue : queues) {
                while (!queue.isEmpty()) {
                    numbers[idx++] = queue.poll();
                }
            }

            factor *= 10;
        }

    }
}
