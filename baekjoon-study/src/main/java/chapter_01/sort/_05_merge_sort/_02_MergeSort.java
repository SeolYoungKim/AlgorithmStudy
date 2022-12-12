package chapter_01.sort._05_merge_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1517 "버블 소트 프로그램 2"
 * - 병합 정렬 특성 상, 오른쪽 부분리스트가 작은 경우, 버블 소트의 swap과 같은 일이 벌어진다.
 * - 왼쪽 부분리스트가 전부 작다면, swap같은 건 발생하지 않음. 즉, 오른쪽이 작아야 swap이 발생한다. (왼쪽부터 채우니까)
 * - 이러한 병합 정렬의 특성을 이용했던 문제.. 너무 어려웠다..
 */
public class _02_MergeSort {
    // 자기의 오른쪽에 있는 자기보다 작은 숫자의 개수 세기

//8
//3 2 8 1 7 4 5 6
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            mergeSort(numbers);
            System.out.println(Arrays.toString(numbers));
            System.out.println(count);
        }
    }

    public static int count = 0;
    public static int[] temp;

    public static void mergeSort(int[] arr) {
        temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        temp = null;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int leftIdx = left;  // 왼쪽 부분리스트 시작 인덱스
        int rightIdx = mid + 1;  // 오른쪽 부분리스트 시작 인덱스
        int idx = left;  // 채워야 할 인덱스

        while (leftIdx <= mid && rightIdx <= right) {
            if (arr[leftIdx] <= arr[rightIdx]) {
                temp[idx] = arr[leftIdx];
                idx++;
                leftIdx++;
            } else {
                count += (rightIdx - idx);  //TODO 이걸 생각하기가 너무 어려웠다 ㅠ

                temp[idx] = arr[rightIdx];
                idx++;
                rightIdx++;
            }
        }

        // 잔반 처리
        while (rightIdx <= right) {
            count += (rightIdx - idx);
            temp[idx] = arr[rightIdx];
            idx++;
            rightIdx++;
        }

        while (leftIdx <= mid) {
            temp[idx] = arr[leftIdx];
            idx++;
            leftIdx++;
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
