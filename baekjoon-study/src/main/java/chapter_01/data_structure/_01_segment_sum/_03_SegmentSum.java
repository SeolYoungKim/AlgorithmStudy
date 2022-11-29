package chapter_01.data_structure._01_segment_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 10986 "나머지 합 구하기" 문제
 */
public class _03_SegmentSum {

    /**
     * 문제 분석
     * 첫번째 줄 : NM -> N개의 수, M으로 나누어 떨어짐
     * 두번째 줄 : N개의 숫자
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 구간 합을 구한다.
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] segmentSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            segmentSum[i] = segmentSum[i - 1] + Integer.parseInt(st2.nextToken());
        }

        // 구간 합을 모두 m으로 나눈 나머지를 구한다.
        int result = 0;
        int[] remainderCount = new int[m];
        for (int i = 1; i <= n; i++) {
            int remainder = segmentSum[i] % m;

            if (remainder == 0) {
                result++;
            }

            // 나머지에 해당하는 값(예제에서는 0, 1, 2 중 하나가 나올것임.)에 해당하는 index의 값을 1씩 올림
            remainderCount[remainder]++;
        }

        // 나머지의 갯수 별로 같은 경우를 구함 ((0,0), (1,1), (2,2) 일 경우의 수를 구해서 result에 더함.)
        for (int i = 0; i < m; i++) {
            int remainders = remainderCount[i];
            if (remainders > 1) {
                result += (remainders * (remainders - 1) / 2);
            }
        }

        System.out.println(result);
    }

}
