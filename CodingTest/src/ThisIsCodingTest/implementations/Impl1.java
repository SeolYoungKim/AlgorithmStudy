package ThisIsCodingTest.implementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 상하좌우 문제
 */
public class Impl1 {
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        int x = 1, y = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] directions = br.readLine().split(" ");
        int moveCount = directions.length;

        // L : 왼쪽 한칸, R: 오른쪽 한칸
        // U : 위로 한칸, D: 아래로 한칸

        for (String direction : directions) {
            if (direction.equals("L") && y != 1) {
                y -= 1;
            } else if (direction.equals("R") && y != N) {
                y += 1;
            } else if (direction.equals("U") && x != 1) {
                x -= 1;
            } else if (direction.equals("D") && x != N) {
                x += 1;
            }
        }

        System.out.println("x = " + x);
        System.out.println("y = " + y);


    }
}
