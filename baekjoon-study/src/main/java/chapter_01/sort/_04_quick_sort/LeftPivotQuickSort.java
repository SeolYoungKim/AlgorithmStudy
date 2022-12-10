package chapter_01.sort._04_quick_sort;

import java.util.Arrays;

public class LeftPivotQuickSort {
    public static void main(String[] args) {
        int[] arr = {42, 32, 24, 60, 15, 5, 90, 45};
        sort(arr);

        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr) {
        leftPivotSort(arr, 0, arr.length - 1);
    }

    private static void leftPivotSort(int[] arr, int lowIdx, int highIdx) {
        //TODO lowIdx >= highIdx
        // -> 정렬할 원소가 1개 이하이므로, 정렬하지 않고 return
        if (lowIdx >= highIdx) {
            return;
        }

        int pivot = partition(arr, lowIdx, highIdx);  //TODO pivot의 위치를 기준으로, 아래의 분할을 시작한다.

        leftPivotSort(arr, lowIdx, pivot - 1);  // pivot 기준 왼쪽 분할 리스트
        leftPivotSort(arr, pivot + 1, highIdx);  // pivot 기준 오른쪽 분할 리스트
    }

    //TODO pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메소드 (파티셔닝)
    private static int partition(int[] arr, int left, int right) {  // 현재 배열의 가장 왼쪽 부분, 가장 오른쪽 부분
        int lowIdx = left;
        int highIdx = right;
        int pivot = arr[left];  // 해당 리스트의 왼쪽 요소를 피벗으로 설정

        while (lowIdx < highIdx) {
            //TODO highIdx > lowIdx이면서, highIdx의 요소가 pivot보다 작거나 같은 원소를 찾을 때 까지 highIdx를 왼쪽으로 이동 (pivot보다 작은 원소 탐색)
            while (pivot < arr[highIdx] && lowIdx < highIdx) {
                highIdx--;
            }

            //TODO highIdx > lowIdx이면서, lowIdx의 요소가 pivot보다 큰 원소를 찾을 때 까지 lowIdx를 오른쪽으로 이동.
            while (arr[lowIdx] <= pivot && lowIdx < highIdx) {
                lowIdx++;
            }

            //TODO 교환할 두 요소를 찾았으니 서로 swap한다.
            swap(arr, lowIdx, highIdx);
        }

        //TODO swap과정을 전부 수행하고, lowIdx와 highIdx가 같아진 경우, pivot과 lowIdx가 가리키는 원소를 swap
        // left : 피벗 기준이 되었던 index
        swap(arr, left, lowIdx);

        return lowIdx;  //TODO 마지막으로 lowIdx의 요소와 left의 요소를 바꿨으므로, lowIdx가 pivot의 위치가 된다.
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
