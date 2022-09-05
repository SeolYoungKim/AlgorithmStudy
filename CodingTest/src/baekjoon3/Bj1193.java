package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int line = 0;
        int cnt = 0;  // 각 라인의 마지막 숫자
        int top = 0;
        int bottom = 0;

        // 1:  1/1 (1) > 합 2
        // 2:  2/1, 1/2 (2, 3) > 합 3
        // 3:  1/3, 2/2, 3/1 (4, 5, 6) > 합 4
        // 4:  4/1, 3/2, 2/3, 1/4 (7, 8, 9, 10) > 합 5
        // 5:  5/1, 4/2, 3/3, 2/4, 1/5 (11, 12, 13, 14, 15) > 합 6

        // 홀수 그룹은 분자가 정방향
        // 짝수 그룹은 분모가 정방향

        while (cnt < n) {
            line++;
            cnt = line * (line + 1) / 2;
        }

        if (line % 2 != 0) {
            top = 1 + cnt - n;
            bottom = line + n - cnt;
        } else {
            bottom = 1 + cnt - n;
            top = line + n - cnt;
        }

        System.out.println(top + "/" + bottom);

    }
}
