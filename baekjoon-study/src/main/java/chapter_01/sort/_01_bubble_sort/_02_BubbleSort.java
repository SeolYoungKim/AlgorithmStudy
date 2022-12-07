package chapter_01.sort._01_bubble_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 1377번 "버블 소트 프로그램 1"
 */
public class _02_BubbleSort {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            Data[] datas = new Data[n];
            for (int i = 0; i < n; i++) {
                datas[i] = new Data(i, Integer.parseInt(br.readLine()));
            }

            Arrays.sort(datas);
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (max < datas[i].idx - i) {
                    max = datas[i].idx - i;
                }
            }

            System.out.println(max + 1);
        }
    }

    static class Data implements Comparable<Data> {
        private final int idx;
        private final int val;

        public Data(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Data that) {
            return this.val - that.val;
        }
    }

}
