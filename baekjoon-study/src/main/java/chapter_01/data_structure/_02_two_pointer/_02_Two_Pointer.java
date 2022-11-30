package chapter_01.data_structure._02_two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1940 문제 "주몽의 명령"
 */
public class _02_Two_Pointer {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            final int n = Integer.parseInt(br.readLine());  // 재료 개수
            final int m = Integer.parseInt(br.readLine());  // 두 재료의 합

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] materials = new int[n];
            for (int i = 0; i < n; i++) {
                materials[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(materials);

            int leftIdx = 0;
            int rightIdx = n - 1;
            int count = 0;

            while (leftIdx < rightIdx) {
                int left = materials[leftIdx];
                int right = materials[rightIdx];
                int sum = left + right;

                if (sum > m) {
                    rightIdx--;
                } else if (sum == m) {
                    count++;
                    rightIdx--;
                } else {
                    leftIdx++;
                }
            }

            System.out.println(count);
        }
    }
}
