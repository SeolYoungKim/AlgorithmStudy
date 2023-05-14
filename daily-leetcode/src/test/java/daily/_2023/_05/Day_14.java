package daily._2023._05;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class Day_14 {
    public int maxScore(int[] nums) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(nums, 1, 0, memo);
    }
    private int helper(int[] nums, int i, int mask, Map<String, Integer> memo) {
        if (i > nums.length / 2) {
            return 0;
        }

        String key = i + "," + mask;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int maxScore = 0;
        for (int j = 0; j < nums.length; j++) {
            if ((mask & (1 << j)) == 0) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((mask & (1 << k)) == 0) {
                        int newMask = mask | (1 << j) | (1 << k);
                        int score = i * gcd(nums[j], nums[k]) + helper(nums, i + 1, newMask, memo);
                        maxScore = Math.max(maxScore, score);
                    }
                }
            }
        }

        memo.put(key, maxScore);
        return maxScore;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    @Test
    void test() {
        assertThat(maxScore(new int[]{3, 4, 6, 8})).isEqualTo(11);
    }
}
