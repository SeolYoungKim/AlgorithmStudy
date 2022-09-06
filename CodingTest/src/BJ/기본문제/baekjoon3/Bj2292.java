package BJ.기본문제.baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1 : 1번방
        // 2 ~ 7 : 2번방 (6개)
        // 8 ~ 19 : 3번방 (12개)
        // 20 ~ 37 : 4번방 (18개)

        int room = 1;
        int initOfRoom = 2;  // 2번방의 시작점

        if (n == 1) {
            System.out.println(1);
        } else {
            while (initOfRoom <= n) {  // 방의 시작 값보다 n이 작을 경우, n은 직전 방에 있는것. (n이 18인데, 시작 값이 20번(4번방)인 경우 -> n은 3번방에 있다.)
                initOfRoom += (6 * room);
                room++;
            }

            System.out.println(room);
        }

    }
}
