package daily._2023._04;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Day_26 {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }

        final int digitCount = (int) (Math.log10(num) + 1);
        int divider = 10;
        int result = 0;
        for (int i = 0; i < digitCount; i++) {
            result += (num % divider);
            num /= divider;
            divider *= 10;
        }

        if (digitCount == 1) {
            return result;
        }

        return addDigits(result);
    }

    @Test
    void test() {
//        assertThat(addDigits(38)).isEqualTo(2);
        assertThat(addDigits(0)).isEqualTo(0);
    }
}
