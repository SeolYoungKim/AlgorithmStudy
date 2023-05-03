package daily._2023._05;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day_03 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        final Set<Integer> set1 = Arrays.stream(nums1).boxed()
                .collect(Collectors.toSet());

        final Set<Integer> set2 = Arrays.stream(nums2).boxed()
                .collect(Collectors.toSet());

        final List<Integer> res1 = set1.stream()
                .filter(num -> !set2.contains(num))
                .toList();

        final List<Integer> res2 = set2.stream()
                .filter(num -> !set1.contains(num))
                .toList();

        return List.of(res1, res2);
    }

    @Test
    void test() {
        assertThat(findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}))
                .isEqualTo(List.of(List.of(1, 3), List.of(4, 6)));

        assertThat(findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}))
                .isEqualTo(List.of(List.of(3), List.of()));
    }
}
