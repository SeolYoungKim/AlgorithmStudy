package chapter_01.data_structure._01_segment_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * 백준 2167번 "2차원 배열의 합" 문제
 */
public class _04_SegmentSum {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer inputNM = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(inputNM.nextToken());
            int m = Integer.parseInt(inputNM.nextToken());

            int[][] matrix = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                StringTokenizer row = new StringTokenizer(br.readLine());
                for (int j = 1; j <= m; j++) {
                    matrix[i][j] = Integer.parseInt(row.nextToken());
                }
            }

            // 구간 합
            int[][] sum = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i][j];
                }
            }

            int k = Integer.parseInt(br.readLine());
            StringJoiner sj = new StringJoiner("\n");
            for (int i = 0; i < k; i++) {
                StringTokenizer fromTo = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(fromTo.nextToken());
                int y1 = Integer.parseInt(fromTo.nextToken());
                int x2 = Integer.parseInt(fromTo.nextToken());
                int y2 = Integer.parseInt(fromTo.nextToken());

                sj.add(sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1] + "");
            }

            System.out.println(sj);

        }

    }
}
