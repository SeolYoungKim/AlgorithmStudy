package chapter_01.sort._05_merge_sort;

import java.util.Arrays;

//https://gyoogle.dev/blog/algorithm/Merge%20Sort.html
public class MergeSortVer2 {
    public static void main(String[] args) {
        int[] array = { 230, 10, 60, 550, 40, 220, 20 };
        mergeSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {  //TODO 원소가 1개인 경우는 서로 비교대상이 없음
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);  //TODO 즉, 원소가 2개인 시점부터 머지
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        //TODO 왼쪽, 오른쪽 부분 리스트를 만든다. (복사)
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);  // left ~ mid
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);  // mid + 1 ~ right

        int l = 0;  // 왼쪽 부분리스트의 포인터 시작점
        int r = 0;  // 오른쪽 부분리스트의 포인터 시작점
        int idx = left;  // 원소를 저장할 index

        int leftLength = leftArr.length;
        int rightLength = rightArr.length;

        while (l < leftLength && r < rightLength) {
            if (leftArr[l] <= rightArr[r]) {  //TODO 왼쪽 부분리스트 요소가 오른쪽 부분리스트 요소보다 작은 경우
                arr[idx] = leftArr[l++];  //TODO 왼쪽 부분리스트의 요소를 인덱스에 넣는다
            } else {  //TODO 오른쪽 부분리스트의 요소가 작은 경우
                arr[idx] = rightArr[r++];  //TODO 오른쪽 부분리스트의 요소를 인덱스에 넣는다
            }

            idx++;
        }

        //TODO 남은거 처리
        while (l < leftLength) {
            arr[idx++] = leftArr[l++];
        }

        while (r < rightLength) {
            arr[idx++] = rightArr[r++];
        }
    }
}
