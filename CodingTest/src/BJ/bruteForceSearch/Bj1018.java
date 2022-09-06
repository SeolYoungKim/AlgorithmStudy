package BJ.bruteForceSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 체스판 다시 칠하기
 */

public class Bj1018 {

    static ArrayList<String> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for (int i = 0; i < n; i++) {
            arr.add(br.readLine());
        }

        // 8x8 로 자른다 -- 즉, 시작점부터 8개까지만 본다.
        // 즉, 주어진 n, m값에 대해 -8 까지만 시작점으로써 사용할 수 있다.
        int initPointN = n - 7;
        int initPointM = m - 7;

        int sol = Integer.MAX_VALUE;

        for (int i = 0; i < initPointN; i++) {
            for (int j = 0; j < initPointM; j++) {

                int curSol = getSolution(i, j, arr);  // 시작점에 대한 값을 해당 메서드에 넘겨준다. (시작점 다르게 처리)

                if (sol > curSol) sol = curSol;
            }
        }

        System.out.println(sol);


    }

    // 체스판의 시작점(왼쪽 위)이 White인 경우만 계산하고, Black인 경우는 64-(white 경우의 수) 이기 때문에, 둘 중 하나를 리턴하면 된다.
    private static int getSolution(int startRow, int startCol, ArrayList<String> arr) {
        ArrayList<String> orgBoard = new ArrayList<>();  // 왼쪽 위 시작점이 W인 경우의 정답지이다.
        orgBoard.add("WBWBWBWB");  // 첫번째 줄은 무조건 해당 경우여야 한다.(홀수 줄)
        orgBoard.add("BWBWBWBW");  // 다음 줄은 무조건 해당 경우여야 한다.(짝수 줄)

        int whiteCount = 0;

        for (int i = 0; i < 8; i++) {
            int row = startRow + i;  // 시작 row부터 8개 확인

            for (int j = 0; j < 8; j++) {
                int col = startCol + j;  // 시작 column부터 8개 확인

                // orgBoard.get(row % 2) 는 0 또는 1의 값만 가져온다. 즉, orgBoard의 0번째 값과 1번째 값만 가져온다.
                if (arr.get(row).charAt(col) != orgBoard.get(row % 2).charAt(j)) whiteCount++;
            }
        }

        return Math.min(whiteCount, 64 - whiteCount);
    }
}
