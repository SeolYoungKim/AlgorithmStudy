package daily._2023._05;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day_08 {
    public int diagonalSum(int[][] mat) {
        final int n = mat.length;

        // case : [ \ ]
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            leftSum += mat[i][i];
        }

        // case : [ / ]
        int rightSum = 0;
        for (int i = 0; i < n; i++) {
            rightSum += mat[i][n - 1 - i];
        }

        if (n % 2 == 0) {  // n이 짝수
            return leftSum + rightSum;
        }

        return leftSum + rightSum - mat[n / 2][n / 2];
    }

    public int diagonalSum2(int[][] mat) {
        final int n = mat.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i] + mat[i][n - 1 - i];
        }

        if (n % 2 == 0) {  // n이 짝수
            return sum;
        }

        return sum - mat[n / 2][n / 2];
    }

    @Test
    void test() {
        assertThat(diagonalSum2(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})).isEqualTo(25);
        assertThat(diagonalSum2(new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}})).isEqualTo(5);
    }
}
