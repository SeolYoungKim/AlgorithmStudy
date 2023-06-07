package daily._2023._06;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Day_07 {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a > 0 || b > 0 || c > 0) {
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            if (bitC == 0) {
                flips += (bitA + bitB);
            } else {
                if (bitA == 0 && bitB == 0) {
                    flips += 1;
                }
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }

    @Test
    void test() {
        assertThat(minFlips(2, 6, 5)).isEqualTo(3);
        assertThat(minFlips(4, 2, 7)).isEqualTo(1);
        assertThat(minFlips(1, 2, 3)).isEqualTo(0);
        assertThat(minFlips(7, 3, 9)).isEqualTo(4);
    }
}
