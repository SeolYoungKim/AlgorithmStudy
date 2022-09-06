package BJ.bruteForceSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;

/**
 * 사탕 게임
 * 교환은 단 1번만 이루어진다.
 * 같지 않을때만 교환이 일어나는게 아니다.
 * TODO: 스스로 다시 한번 풀어봐야 할 것 같다. 반성포인트: 솔직히 길어지는거 귀찮아서 다른방법 찾다가 쉬운 방법 놓치고 계속 뺑글뺑글 돌았다.
 */

public class Bj3805 {
    static int totalCount = 0;
    static int n;

    public static void check(char[][] charArr) {

        // 행 체크
        for (int i = 0; i < n; i++) {
            int countTemp = 1;
            for (int j = 0; j < n - 1; j++) {
                char prev = charArr[i][j];
                char post = charArr[i][j + 1];

                if (prev == post) {
                    countTemp += 1;
                } else {  // 한번이라도 다르면 카운트를 초기화해야 함. (중복 체크 방지)
                    countTemp = 1;
                }

                totalCount = max(totalCount, countTemp);
            }
        }

        // 열 체크
        for (int i = 0; i < n; i++) {
            int countTemp = 1;

            for (int j = 0; j < n - 1; j++) {

                char prev = charArr[j][i];
                char post = charArr[j + 1][i];

                if (prev == post) {
                    countTemp += 1;
                } else {  // 한번이라도 다르면 카운트를 초기화해야 함. (중복 체크 방지)
                    countTemp = 1;
                }

                totalCount = max(totalCount, countTemp);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        n = Integer.parseInt(bf.readLine());
        char[][] charArr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String readLine = bf.readLine();
            for (int j = 0; j < n; j++) {
                charArr[i][j] = readLine.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                char prev = charArr[i][j];
                char post = charArr[i][j + 1];

                charArr[i][j] = post;
                charArr[i][j + 1] = prev;

                check(charArr);

                charArr[i][j] = prev;
                charArr[i][j + 1] = post;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                char prev = charArr[j][i];
                char post = charArr[j + 1][i];

                charArr[j][i] = post;
                charArr[j + 1][i] = prev;

                check(charArr);

                charArr[j][i] = prev;
                charArr[j + 1][i] = post;
            }
        }

        System.out.println("count=" + totalCount);

    }

}
