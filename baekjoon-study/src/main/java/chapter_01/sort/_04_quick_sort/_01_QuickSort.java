package chapter_01.sort._04_quick_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11004번 "K번째 수 구하기"
 */
public class _01_QuickSort {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st2.nextToken());
            }

            quickSortCenter(numbers);
            System.out.println(numbers[k - 1]);
        }
    }

    // 위 문제를 퀵 정렬로 풀어보자.
    //TODO 1. 왼쪽 피벗
    public static void quickSortLeft(int[] numbers) {
        leftPivotQuickSort(numbers, 0, numbers.length - 1);
    }

    private static void leftPivotQuickSort(int[] numbers, int lowIdx, int highIdx) {
        if (lowIdx >= highIdx) {
            return;
        }

        int pivot = partition(numbers, lowIdx, highIdx);  //TODO 얘는 자르는 기준점
        leftPivotQuickSort(numbers, lowIdx, pivot - 1);  //TODO 피벗을 기점으로 왼쪽에는 작은 값들이 있고
        leftPivotQuickSort(numbers, pivot + 1, pivot - 1);  //TODO 피벗을 기점으로 오른쪽에는 큰 값들이 있다.
    }

    private static int partition(int[] numbers, int left, int right) {
        int lowIdx = left;
        int highIdx = right;
        int pivot = numbers[left];

        while (lowIdx < highIdx) {
            while (pivot < numbers[highIdx] && lowIdx < highIdx) {
                highIdx--;
            }

            while (numbers[lowIdx] <= pivot && lowIdx < highIdx) {
                lowIdx++;
            }

            swap(numbers, lowIdx, highIdx);
        }

        //TODO 피벗의 값과 lowIdx 위치의 값을 서로 바꾼다
        swap(numbers, lowIdx, left);

        return lowIdx;  //TODO 현재 lowIdx 위치가 피벗의 위치가 된다. (분할 위치가 된다)
    }

    //TODO 2. 중간 피벗
    public static void quickSortCenter(int[] numbers) {
        centerPivotQuickSort(numbers, 0, numbers.length - 1);
    }
    private static void centerPivotQuickSort(int[] numbers, int lowIdx, int highIdx) {
        if (lowIdx >= highIdx) {  //TODO 더 분할 할수 있는 게 없다!
            return;
        }

        int pivot = partitionVerCenter(numbers, lowIdx, highIdx);
        centerPivotQuickSort(numbers, lowIdx, pivot);
        centerPivotQuickSort(numbers, pivot + 1, highIdx);
    }

    private static int partitionVerCenter(int[] numbers, int left, int right) {
        int lowIdx = left - 1;
        int highIdx = right + 1;
        int pivot = numbers[(left + right) / 2];

        while (true) {
            do {
                lowIdx++;
            } while (numbers[lowIdx] < pivot);

            do {
                highIdx--;
            } while (pivot < numbers[highIdx] && lowIdx <= highIdx);

            if (lowIdx >= highIdx) {
                return highIdx;
            }

            swap(numbers, lowIdx, highIdx);
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
