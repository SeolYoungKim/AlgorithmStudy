package chapter_01.sort._06_radix_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RadixSort {
    public static void radixSort(int[] arr) {
        List<Queue<Integer>> queues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            queues.add(new LinkedList<>());
        }

        for (int num : arr) {
            // 일의 자리로 분류해서 집어넣는다
            int digit = num % 10;
            queues.get(digit).offer(num);
        }

        //queue를 돌면서 데이터를 정렬
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            Queue<Integer> queue = queues.get(i);
            while (!queue.isEmpty()) {
                arr[idx++] = queue.poll();
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(queues);

        // 십의 자릿수를 기준으로 다시 데이터 저장
        for (int num : arr) {
            int digit = num / 10;
            queues.get(digit).offer(num);
        }

        System.out.println(queues);
        idx = 0;
        for (int i = 0; i < 10; i++) {
            Queue<Integer> queue = queues.get(i);
            while (!queue.isEmpty()) {
                arr[idx++] = queue.poll();
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(queues);
    }

    public static void main(String[] args) {
        System.out.println(85 % 10);  // 10으로 나눴을 때 나머지 = 일의자리
        System.out.println((85/10) % 10);  // 10으로 나누고 그걸 10으로 나눴을 때 나머지 = 십의자리
        System.out.println((85/100) % 10);  // 100으로 나누고 그걸 10으로 나눴을 때 나머지 = 십의자리
//        System.out.println(85 / 10);  // 10으로 나눴을 때 몫 = 십의자리
//        System.out.println(85 / 100); // 100으로 나눴을 때 몫 = 백의자리

        int[] numbers = {16, 80, 18, 77, 3, 24, 88, 23};
        radixSort(numbers);

    }
}
