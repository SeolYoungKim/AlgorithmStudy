package daily._2023._04;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day_27 {
    public int bulbSwitchMyVer(int n) {  // 시간 초과남ㅋㅋㅋㅋㅋㅋㅋ
        final boolean[] bulbs = new boolean[n];
        // round 1
        Arrays.fill(bulbs, true);

        // round 2~
        for (int round = 2; round <= n; round++) {  //round2 ~ roundN
            for (int idx = (round - 1); idx < n; idx += round) {
                bulbs[idx] = !bulbs[idx];
            }
        }

        int count = 0;
        for (boolean bulb : bulbs) {
            if (bulb) {
                count++;
            }
        }

        return count;
    }

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    @Test
    void test() {
        assertThat(bulbSwitch(3)).isEqualTo(1);
        assertThat(bulbSwitch(0)).isEqualTo(0);
        assertThat(bulbSwitch(1)).isEqualTo(1);
    }
}
