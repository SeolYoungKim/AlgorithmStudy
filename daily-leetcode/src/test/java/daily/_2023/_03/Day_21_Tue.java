package daily._2023._03;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Day_21_Tue {
    public static long zeroFilledSubarray(int[] nums) {
        long res = 0;
        for (int i = 0, j = 0; i < nums.length; ++i) {
            if (nums[i] != 0)
                j = i + 1;
            res += i - j + 1;
        }
        return res;
    }

    public static long zeroFilledSubarrayTrash(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] == 0) {
                return 1;
            }

            return 0;
        }

        // 0으로 구성된 subArray를 찾자
        final List<Long> list = new ArrayList<>();

        long count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                count++;

                if (nums[i + 1] != 0) {
                    list.add(count);
                    count = 0;
                    continue;
                }

                if (i == nums.length - 2) {
                    if (nums[i + 1] == 0) {
                        count++;
                        list.add(count);
                    }
                }
            }

            if ((nums[i] != 0) && (i == nums.length - 2)) {
                if (nums[i + 1] == 0) {
                    list.add(1L);
                }
            }
        }

        long result = 0;
        for (Long num : list) {
            result += (num + 1) * num / 2;
        }

        return result;
    }

    @Test
    void test() {
        assertThat(zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4})).isEqualTo(6);
        assertThat(zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0})).isEqualTo(9);
        assertThat(zeroFilledSubarray(new int[]{2, 10, 2019})).isEqualTo(0);
        assertThat(zeroFilledSubarray(new int[]{0, 12, 0, 12, 0, -8, 0, -18, 0, -11, 0})).isEqualTo(6);
    }
}
