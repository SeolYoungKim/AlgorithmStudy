package daily._2023._05;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day_02 {
    public int arraySign(int[] nums) {
        int multiply = 1;
        for (int num : nums) {
            if (num < 0) {
                multiply *= -1;
            }

            if (num == 0) {
                return 0;
            }
        }

        return multiply > 0 ? 1 : -1;
    }

    @Test
    void test() {
        assertThat(arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1})).isEqualTo(1);
        assertThat(arraySign(new int[]{1, 5, 0, 2, -3})).isEqualTo(0);
        assertThat(arraySign(new int[]{-1, 1, -1, 1, -1})).isEqualTo(-1);
        assertThat(arraySign(new int[]{9, 72, 34, 29, -49, -22, -77, -17, -66, -75, -44, -30, -24}))
                .isEqualTo(-1);
        assertThat(arraySign(new int[]{56,32,76,92,78,91,-100,-82,-40,-63,-48,-55,-59,-81,-35,-59,-29}))
                .isEqualTo(-1);
    }
}
