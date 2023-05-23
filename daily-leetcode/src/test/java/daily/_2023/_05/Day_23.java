package daily._2023._05;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day_23 {
    private static class KthLargest {
        private final List<Integer> numbers = new ArrayList<>();
        private final int k;

        public KthLargest(int k, int[] nums) {
            for (int num : nums) {
                numbers.add(num);
            }

            this.k = k;
        }

        public int add(int val) {
            numbers.add(val);
            numbers.sort(Collections.reverseOrder());

            return numbers.get(k - 1);
        }
    }

    @Test
    void test() {
        final KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        assertThat(kthLargest.add(3)).isEqualTo(4);
        assertThat(kthLargest.add(5)).isEqualTo(5);
        assertThat(kthLargest.add(10)).isEqualTo(5);
        assertThat(kthLargest.add(9)).isEqualTo(8);
        assertThat(kthLargest.add(4)).isEqualTo(8);
    }

    class KthLargestMinHeap {
        private int k;
        private PriorityQueue<Integer> minHeap;

        public KthLargestMinHeap(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (minHeap.size() < k) {
                minHeap.offer(val);
            } else if (val > minHeap.peek()) {  // k번째로 큰 수가 priority queue의 root에 존재하게 함
                minHeap.poll();
                minHeap.offer(val);
            }
            return minHeap.peek();
        }
    }

    @Test
    void test2() {
        final KthLargestMinHeap kthLargest = new KthLargestMinHeap(3, new int[]{4, 5, 8, 2});
        assertThat(kthLargest.add(3)).isEqualTo(4);
        assertThat(kthLargest.add(5)).isEqualTo(5);
        assertThat(kthLargest.add(10)).isEqualTo(5);
        assertThat(kthLargest.add(9)).isEqualTo(8);
        assertThat(kthLargest.add(4)).isEqualTo(8);
    }
}
