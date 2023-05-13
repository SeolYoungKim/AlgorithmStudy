package daily._2023._05;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class Day_13 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        final Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        int mod = 1_000_000_000 + 7;

        // 1부터 high까지의 경우의 수를 map에 모두 저장
        for (int i = 1; i <= high; i++) {
            final Integer zeroDp = dp.getOrDefault(i - zero, 0);  // 이전의 자기 자신을 붙일 수 있는 길이에 대한 경우의 수(n)에 자기 자신을 붙이는 경우는 n이 됨
            final Integer oneDp = dp.getOrDefault(i - one, 0);  // 이전의 자기 자신을 붙일 수 있는 길이에 대한 경우의 수(n)에 자기 자신을 붙이는 경우는 n이 됨
            final int n = (zeroDp + oneDp) % mod;  // 이전 길이에 대한 경우의 수(n)에 zero를 붙이는 경우 + one을 붙이는 경우 -> 결국 현재 길이에 대한 경우의 수가 됨...

            dp.put(i, n);  // 현재 길이에 대한 경우의 수 저장
        }

        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans = (ans + dp.getOrDefault(i, 0)) % mod;  // 그저 low부터 high까지의 경우의 수를 전부 합하면 됨...
        }

        return ans;
    }

    @Test
    void test() {
        assertThat(countGoodStrings(3, 3, 1, 1)).isEqualTo(8);
        assertThat(countGoodStrings(2, 3, 1, 2)).isEqualTo(5);
    }
}
