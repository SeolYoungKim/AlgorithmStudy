package BJ.기본문제.bj_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2447 {

    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new char[n][n];

        star(0, 0, n, false);  // 1. 원하는 사이즈의 별 박스를 만들 함수 호출 ex: 27 사이즈 (27 x 27) [스택에 쌓임]

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void star(int x, int y, int n, boolean empty) {

        if (empty) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (n == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = n / 3;  // 2. 사이즈 27의 함수가 size 9 함수를 호출하기 위한 로직
        int count = 0;  // 5번째 마다 빈 칸을 작성하기 위한 로직

        for (int i = x; i < x + n; i += size) {  // 별을 그리는 메인 로직
            for (int j = y; j < y + n; j += size) {
                count++;

                star(i, j, size, count == 5);
            }
        }


    }
}
