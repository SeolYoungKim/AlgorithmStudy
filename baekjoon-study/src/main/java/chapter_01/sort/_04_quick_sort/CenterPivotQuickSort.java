package chapter_01.sort._04_quick_sort;

import java.util.Arrays;

/**
 * 대충 재귀에 대해 알 것 같다.
 * 분할 포인트를 찾고 -> 분할 값을 전달해 같은 일을 처리하게 한다 .
 */
public class CenterPivotQuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 9, 2, 4, 7};
        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        centerPivotSort(arr, 0, arr.length - 1);
    }

    private static void centerPivotSort(int[] arr, int lowIdx, int highIdx) {
        if (lowIdx >= highIdx) {
            return;
        }

        int splitPoint = partition(arr, lowIdx, highIdx);  //TODO 분할 포인트 탐색 및 정렬은 여기서!

        centerPivotSort(arr, lowIdx, splitPoint);  //TODO 왼쪽 분할 리스트
        centerPivotSort(arr, splitPoint + 1, highIdx);  //TODO 오른쪽 분할 리스트
    }

    private static int partition(int[] arr, int left, int right) {
        int lowIdx = left - 1;
        int highIdx = right + 1;
        int pivot = arr[(right + left) / 2];

        while (true) {
            //TODO 1 증가시키고 난 뒤의 lowIdx 위치의 요소가 pivot보다 크거나 같은 요소를 찾을 때 까지 반복
            do {
                lowIdx++;
            } while (arr[lowIdx] < pivot);

            //TODO 1 감소시키고 난 뒤의 highIdx 위치의 요소가 lowIdx 위치의 요소보다 크거나 같은 위치이면서,
            // highIdx 위치의 요소가 pivot보다 작은 요소를 찾을 때 까지 반복
            do {
                highIdx--;
            } while (arr[highIdx] > pivot && lowIdx <= highIdx);

            //TODO 만약, highIdx가 lowIdx보다 작거나 같다면 swap하지 않고 highIdx를 리턴
            if (lowIdx >= highIdx) {
                return highIdx;
            }

            swap(arr, lowIdx, highIdx);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
