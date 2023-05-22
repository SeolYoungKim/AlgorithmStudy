package daily._2023._05;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day_22 {
    public int[] topKFrequent(int[] nums, int k) {
        final Map<Integer, Long> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(number -> number, Collectors.counting()));

        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Entry::getKey)
                .toArray();
    }

    public int[] topKFrequentPriorityQueue(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        final PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        map.forEach((key, val) -> queue.offer(key));

        final int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = queue.poll();
        }

        return results;
    }

    @Test
    void test() {
        assertThat(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)).isEqualTo(new int[]{1, 2});
        assertThat(topKFrequent(new int[]{1}, 1)).isEqualTo(new int[]{1});
    }

    @Test
    void test2() {
        assertThat(topKFrequentPriorityQueue(new int[]{1, 1, 1, 2, 2, 3}, 2)).isEqualTo(new int[]{1, 2});
        assertThat(topKFrequentPriorityQueue(new int[]{1}, 1)).isEqualTo(new int[]{1});
    }
}
