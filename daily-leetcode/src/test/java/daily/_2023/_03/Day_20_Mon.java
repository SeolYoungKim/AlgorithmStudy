package daily._2023._03;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Day_20_Mon {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if (flowerbed.length <= 1) {
            return flowerbed[0] == 0 || n == 0;
        }

        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            count++;
            flowerbed[0] = 1;
        }

        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] != 1) {
                count++;
                flowerbed[i] = 1;
            }
        }

        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            count++;
        }

        return count >= n;
    }

    private static final int[] FLOWERBED = {1, 0, 1, 0, 1, 0, 1};

    @ParameterizedTest
    @CsvSource({"1,false", "2,false"})
    void test(int n, boolean result) {
        assertThat(canPlaceFlowers(FLOWERBED, n)).isEqualTo(result);
    }
}
