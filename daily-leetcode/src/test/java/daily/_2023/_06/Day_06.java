package daily._2023._06;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class Day_06 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        final int sub1 = arr[0] - arr[1];

        for (int i = 1; i < arr.length - 1; i++) {
            final int sub2 = arr[i] - arr[i + 1];
            if (sub1 != sub2) {
                return false;
            }
        }

        return true;
    }

    @Test
    void test() {
        assertThat(canMakeArithmeticProgression(new int[]{3, 5, 1})).isTrue();
        assertThat(canMakeArithmeticProgression(new int[]{1, 2, 4})).isFalse();
    }
}
