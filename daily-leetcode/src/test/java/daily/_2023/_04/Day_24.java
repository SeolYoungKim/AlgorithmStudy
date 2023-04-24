package daily._2023._04;

import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

public class Day_24 {
    public int lastStoneWeight(int[] stones) {
        Comparator<Integer> comparator = Comparator.comparingInt(x -> x);
        final PriorityQueue<Integer> pq = new PriorityQueue<>(comparator.reversed());

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                return pq.poll();
            }

            final Integer largeOne = pq.poll();
            final Integer smallOne = pq.poll();

            final int newNum = largeOne - smallOne;
            pq.offer(newNum);
        }

        return 0;
    }

    @Test
    void test() {
        final int result = lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
        System.out.println(result);

    }
}
