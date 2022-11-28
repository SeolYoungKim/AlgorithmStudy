package chapter_01.data_structure._01_segment_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * 백준 11660번 "구간합 구하기"문제
 */
public class _02_SegmentSum {

    /**
     * 문제 분석
     * 첫번째 줄 : N M -> N x N 배열이 주어짐 + M회 질의함
     * 두번째 줄 ~ N + 1번째 줄 -> 배열을 채울 숫자
     * 이후의 줄 : X1 Y1 X2 Y2 형태로 주어짐 -> (X1, Y1), (X2, Y2) 형태로 사용. 해당 범위 내의 숫자 합 구하기
     * (X1, Y1~Y2)
     * (X2, Y1~Y2)
     * 위 좌표들의 값의 합을 구하면 됨.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 배열 크기 & 질의 횟수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                array[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        // 구간 합 만들기
        int[][] dSum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dSum[i][j] = dSum[i][j - 1] + dSum[i - 1][j] - dSum[i - 1][j - 1] + array[i][j];
            }
        }

        StringJoiner sj = new StringJoiner("\n");
        for (int i = 0; i < m; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st3.nextToken());
            int y1 = Integer.parseInt(st3.nextToken());
            int x2 = Integer.parseInt(st3.nextToken());
            int y2 = Integer.parseInt(st3.nextToken());

            sj.add(dSum[x2][y2] - dSum[x2][y1 - 1] - dSum[x1 - 1][y2] + dSum[x1 - 1][y1 - 1] + "");
        }

        System.out.println(sj);
    }
}
