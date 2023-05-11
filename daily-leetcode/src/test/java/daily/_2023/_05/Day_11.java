package daily._2023._05;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day_11 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m < n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            m = nums1.length;
            n = nums2.length;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int prev = 0;

            for (int j = 1; j <= n; j++) {
                int curr = dp[j];

                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], curr);
                }
                prev = curr;
            }
        }
        return dp[n];
    }


    @Test
    void test() {
        assertThat(maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4})).isEqualTo(2);
        assertThat(maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2})).isEqualTo(3);
        assertThat(maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1})).isEqualTo(2);
    }
}