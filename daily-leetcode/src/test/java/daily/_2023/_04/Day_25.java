package daily._2023._04;

import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

public class Day_25 {
    static class SmallestInfiniteSet {
        private final PriorityQueue<Integer> pq = new PriorityQueue<>();
        public SmallestInfiniteSet() {
            for (int i = 1; i <= 1001; i++) {
                pq.offer(i);
            }
        }

        public int popSmallest() {
            return pq.poll();
        }

        public void addBack(int num) {
            if (!pq.contains(num)) {
                pq.offer(num);
            }
        }
    }

    @Test
    void test() {
        SmallestInfiniteSet ss = new SmallestInfiniteSet();
        System.out.println(ss.popSmallest());

        ss.addBack(1);
        System.out.println(ss.pq);

        System.out.println(ss.popSmallest());
        System.out.println(ss.popSmallest());
        System.out.println(ss.popSmallest());

        ss.addBack(2);
        ss.addBack(3);
        System.out.println(ss.pq);

        System.out.println(ss.popSmallest());
        System.out.println(ss.popSmallest());
    }
}
