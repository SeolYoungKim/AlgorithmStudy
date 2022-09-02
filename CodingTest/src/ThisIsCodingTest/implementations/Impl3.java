package ThisIsCodingTest.implementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

/**
 * 왕실의 나이트
 */
public class Impl3 {
    // 이동 방향
    static int[] knightColumn = {-2, 2, -1, 1};
    static int[] knightRow = {-2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String location = br.readLine();

        System.out.println("실행 전" + LocalDateTime.now());

        int column = location.charAt(0) - '0' - 48;
        int row = location.charAt(1) - '0';

        int count = 0;

        for (int i = 0; i < 2; i++) {
            if (column + knightColumn[i] >= 1 && column + knightColumn[i] <= 8) {
                for (int j = 0; j < 2; j++) {
                    if (row + knightRow[j + 2] >= 1 && row + knightRow[j + 2] <= 8) {
                        count += 1;
                    }
                }

            }
        }

        for (int i = 0; i < 2; i++) {
            if (row + knightRow[i] >= 1 && row + knightRow[i] <= 8) {
                for (int j = 0; j < 2; j++) {
                    if (column + knightColumn[j + 2] >= 1 && column + knightColumn[j + 2] <= 8) {
                        count += 1;
                    }
                }
            }
        }

        System.out.println("count = " + count);
        System.out.println("실행 후" + LocalDateTime.now());


    }
}
