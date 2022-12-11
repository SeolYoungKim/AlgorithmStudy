package chapter_01.sort._05_merge_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 백준 2751 "수 정렬하기2"
 * 기본으로 풀어서 제출 후, 머지 소트로 구현해보자!
 */
public class _01_MergeSort {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(br.readLine());
            }

            mergeSort(numbers);
            for (int number : numbers) {
                bw.write(number + "\n");
            }

            bw.flush();
        }
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {  //TODO 원소가 한개면 비교 대상이 없어서 그만 자른다.
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);  // 왼쪽 분할 리스트
        mergeSort(arr, mid + 1, right);  // 오른쪽 분할 리스트

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);  // 왼쪽 부분 리스트
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);  // 오른쪽 부분 리스트

        int l = 0;  // 왼쪽 부분 리스트의 포인터
        int r = 0;  // 오른쪽 부분 리스트의 포인터
        int idx = left;  // 병합할 때 넣어줄 인덱스 번호

        int leftLength = leftArr.length;
        int rightLength = rightArr.length;

        while (l < leftLength && r < rightLength) {
            if (leftArr[l] <= rightArr[r]) {
                arr[idx++] = leftArr[l++];
            } else {
                arr[idx++] = rightArr[r++];
            }
        }

        //TODO 잔반 처리
        while (l < leftLength) {
            arr[idx++] = leftArr[l++];
        }

        while (r < rightLength) {
            arr[idx++] = rightArr[r++];
        }
    }

    //TODO 그냥 쉬운 풀이법
//    public void solve() throws IOException {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
//            int n = Integer.parseInt(br.readLine());
//            int[] numbers = new int[n];
//            for (int i = 0; i < n; i++) {
//                numbers[i] = Integer.parseInt(br.readLine());
//            }
//
//            Arrays.sort(numbers);
//            for (int number : numbers) {
//                bw.write(number + "\n");
//            }
//
//            bw.flush();
//        }
//    }
}
