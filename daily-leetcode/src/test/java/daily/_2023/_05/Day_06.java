package daily._2023._05;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class Day_06 {
    public int numSubseq(int[] nums, int target) {
        final int mod = 1000000007;
        Arrays.sort(nums);

        final int[] exp = new int[nums.length];
        exp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            exp[i] = (exp[i - 1] << 1) % mod;
        }

        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                count = (count + exp[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    @Test
    void test() {
        assertThat(numSubseq(new int[]{3, 5, 6, 7}, 9)).isEqualTo(4);
        assertThat(numSubseq(new int[]{3, 3, 6, 8}, 10)).isEqualTo(6);
    }
}
