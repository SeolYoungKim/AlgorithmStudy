package chapter_01.sort._05_merge_sort;

import java.util.Arrays;

//https://st-lab.tistory.com/233
public class MergeSortVer1 {
    private static int[] sorted;

    public static void main(String[] args) {
        int[] numbers = {3, 2, 1};
        mergeSort(numbers);

        System.out.println(Arrays.toString(numbers));
    }

    public static void mergeSort(int[] arr) {
        sorted = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        sorted = null;
    }

    private static void mergeSort(int[] arr, int left, int right) {
        //TODO 부분리스트가 1개의 원소만 가진 경우
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);  // 왼쪽 부분 리스트
        mergeSort(arr, mid + 1, right);  // 오른쪽 부분 리스트

        merge(arr, left, mid, right);  // 병합
    }

    /**
     * 부분리스트는 a배열의 left ~ right 까지이다.
     *
     * @param arr   정렬할 배열
     * @param left  배열의 시작점
     * @param mid   배열의 중간점
     * @param right 배열의 끝 점
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int l = left;  // 왼쪽 부분 리스트의 시작점
        int r = mid + 1;  // 오른쪽 부분 리스트의 시작점
        int idx = left;  // 채워넣을 배열의 인덱스 (왼쪽 부분리스트의 시작점이랑 같다)

        //TODO
        // - 왼쪽 부분 리스트 : l ~ r
        // - 오른쪽 부분 리스트 : r ~ right
        // - 즉, l은 왼쪽 부분 리스트의 인덱스로, r은 오른쪽 부분 리스트의 인덱스로 쓰는 것
        while (l <= mid && r <= right) {
            //TODO 왼쪽 부분 리스트의 l번째 원소가 오른쪽 부분리스트의 r번째 원소보다 작거나 같을 경우
            // 왼쪽의 l번째 원소를 새 배열에 넣고, l과 idx를 1 증가시킨다
            if (arr[l] <= arr[r]) {
                sorted[idx] = arr[l];
                idx++;
                l++;
            }

            //TODO 오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트의 l번째 원소보다 작거나 같을 경우
            // 오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다
            else {
                sorted[idx] = arr[r];
                idx++;
                r++;
            }
        }

        //TODO 왼쪽 부분 리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
        // 즉, 오른쪽 부분리스트의 원소가 아직 남아있을 경우
        // 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다
        if (l > mid) {
            while (r <= right) {
                sorted[idx] = arr[r];
                idx++;
                r++;
            }
        }

        //TODO 오른쪽 부분 리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
        // 즉, 왼쪽 부분 리스트의 원소가 아직 남아있는 경우
        // 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워줌
        else {
            while (l <= mid) {
                sorted[idx] = arr[l];
                idx++;
                l++;
            }
        }

        //TODO 정렬된 새 배열을 기존 배열에 복사하여 옮겨준다.
        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }
}
