package chapter_01.data_structure._02_two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2018번 문제 "연속된 자연수의 합 구하기"
 */
public class _01_Two_Pointer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 1;
        int sum = 1;
        int result = 1; // 자기 자신
        while (end != n) {
            if (sum < n) {
                end++;
                sum += end;
            } else if (sum == n) {
                result++;
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        System.out.println(result);
    }

}
