package daily._2023._05;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day_04 {

    public static final String DIRE = "Dire";
    public static final String RADIANT = "Radiant";
    public static final char DIRE_CHAR = 'D';
    public static final char RADIANT_CHAR = 'R';

    public String predictPartyVictory(String senate) {
        final LinkedList<Integer> rQueue = new LinkedList<>();
        final LinkedList<Integer> dQueue = new LinkedList<>();

        final int length = senate.length();
        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == DIRE_CHAR) {
                dQueue.offer(i);
            } else {
                rQueue.offer(i);
            }
        }

        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            final Integer rIdx = rQueue.poll();
            final Integer dIdx = dQueue.poll();

            if (rIdx < dIdx) {
                rQueue.offer(rIdx + length);
            } else {
                dQueue.offer(dIdx + length);
            }
        }

        return rQueue.size() > dQueue.size() ? RADIANT : DIRE;
    }
    @Test
    void test() {
        assertThat(predictPartyVictory("RD")).isEqualTo("Radiant");
        assertThat(predictPartyVictory("RDD")).isEqualTo("Dire");
    }
}
