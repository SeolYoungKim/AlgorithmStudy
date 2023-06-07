package daily._2023._06;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Day_07 {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a > 0 || b > 0 || c > 0) {
            int bitA = a & 1;  // 최하위 비트를 비트 & 연산을 통해 얻을 수 있음
            int bitB = b & 1;
            int bitC = c & 1;

            if (bitC == 0) {
                flips += (bitA + bitB);  // 1인 비트를 뒤집어야 함 (bitA=1, bitB=0이면 1개만 뒤집고, 둘다 1이면 2개를 뒤집음)
            } else {  // bitC가 1인 경우
                if (bitA == 0 && bitB == 0) {  // 둘 다 0일때, 한 개만 뒤집으면 됨
                    flips += 1;  // 둘 다 1인 경우는 더해서 0이되므로 안셈
                }
            }

            a >>= 1;  // 1비트씩 오른쪽으로 시프트하여 다음 최하위 비트를 구함
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
