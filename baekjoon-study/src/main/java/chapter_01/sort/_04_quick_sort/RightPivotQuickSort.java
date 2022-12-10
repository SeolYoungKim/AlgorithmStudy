package chapter_01.sort._04_quick_sort;

import java.util.Arrays;

public class RightPivotQuickSort {
    public static void main(String[] args) {
        int[] arr = {42, 32, 24, 60, 15, 5, 90, 45};
        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        rightPivotSort(arr, 0, arr.length - 1);
    }

    private static void rightPivotSort(int[] arr, int lowIdx, int highIdx) {
        //TODO lowIdx가 highIdx보다 크거나 같다면 정렬할 요소가 1개 이하이므로 return
        // 즉, 아래와 같은 상황이 있을 수 있겠다.
        // - lowIdx가 pivot-1의 index와 같을 경우
        // - highIdx가 pivot+1의 index와 같을 경우
        if (lowIdx >= highIdx) {  //TODO ==으로 탈출조건 걸어봤는데, 이게 계속 수행되서 lowIdx가 pivot-1보다 커지는 경우가 생김. 그러므로 lowIdx >= highIdx로 조건을 걸어줘서 방지해야 함
            return;
        }

        int pivot = partition(arr, lowIdx, highIdx);
        rightPivotSort(arr, lowIdx, pivot - 1);
        rightPivotSort(arr, pivot + 1, highIdx);
    }

    private static int partition(int[] arr, int left, int right) {
        int lowIdx = left;
        int highIdx = right;
        int pivot = arr[right];

        while (lowIdx < highIdx) {
            //TODO RightPivot 방식은 오른쪽에 큰 값이 몰릴 수 있도록 보장한다. 그렇게 함으로써, Pivot과 highIdx 요소를 서로 바꿨을 때, 오른쪽에는 반드시 큰값들만이 있을 수 있다. (Pivot과 작은 값이 바뀌는것을 방지한다)
            //TODO 오른쪽이 기준으므로, lowIdx먼저 움직인다.
            while (arr[lowIdx] < pivot && lowIdx < highIdx) {
                lowIdx++;
            }

            //TODO highIdx의 시작점은 pivot이므로, 크거나 같으면 움직여야 한다.
            while (pivot <= arr[highIdx] && lowIdx < highIdx) {
                highIdx--;
            }

            //TODO 다 움직이면 swap
            swap(arr, lowIdx, highIdx);
        }

        //TODO 이동이 한차례 끝나면, pivot과 highIdx 요소의 값을 바꾼다.
        swap(arr, highIdx, right);

        return highIdx;  //TODO highIdx가 pivot의 index가 된다.
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
