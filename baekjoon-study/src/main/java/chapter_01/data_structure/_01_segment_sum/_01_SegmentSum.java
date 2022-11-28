package chapter_01.data_structure._01_segment_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

/**
 * 백준 11659번 "구간합 구하기"문제
 */
public class _01_SegmentSum {

    /**
     * 문제 분석
     * 1번째 줄 : N M 형태로, N개의 수 M번 질의
     * 2번째 줄 : 구간합을 구할 N개의 수
     * 3번째 줄 : i j 형태로, 구간 i와 j가 주어지며, 해당 구간의 합을 구해야 한다.
     *
     * ex :
     * 5 3
     * 5 4 3 2 1
     *
     * 1 3 -> 첫번째 숫자부터 세번째 숫자까지의 합 구하기
     * 2 4 -> 두번째 숫자부터 네번째 숫자까지의 합 구하기
     * 5 5 -> 다섯번째 숫자부터 다섯번째 숫자까지의 합 구하기
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] arr = br.readLine().split(" ");
        int[] segmentSum = new int[n];
        segmentSum[0] = Integer.parseInt(arr[0]);

        for (int i = 1; i < n; i++) {  // 구간합을 저장한다.
            segmentSum[i] = segmentSum[i - 1] + Integer.parseInt(arr[i]);
        }

        // 입력받은 질의에 맞는 합을 출력한다.
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (int questionCount = 0; questionCount < m; questionCount++) {
            String[] ij = br.readLine().split(" ");
            int i = Integer.parseInt(ij[0]);
            int j = Integer.parseInt(ij[1]);

            if (i == 1) {
                stringJoiner.add(segmentSum[j - 1] + "");
                continue;
            }

            stringJoiner.add(segmentSum[j - 1] - segmentSum[i - 2] + "");
        }

        System.out.println(stringJoiner);
    }
}
