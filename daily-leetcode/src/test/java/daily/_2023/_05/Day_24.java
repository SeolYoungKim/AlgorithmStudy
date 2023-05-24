package daily._2023._05;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day_24 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i] = new int[]{nums2[i], nums1[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);  // nums2를 기준으로 내림차순 정렬. k개의 수를 확인했을 때, nums2의 값이 최소임을 보장하기 위함.
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.naturalOrder());  // nums1의 값을 오름차순으로 삽입

        long res = 0, totalSum = 0;
        for (int[] pair : pairs) {
            pq.add(pair[1]);  // nums1의 값을 pq에 넣는다.
            totalSum += pair[1];  // nums1의 값을 totalSum에 더한다.

            if (pq.size() > k) {  // pq의 사이즈가 k보다 커질 경우
                totalSum -= pq.poll();  // 가장 작은 값을 pq에서 제거하고, totalSum에서 해당 값을 뺀다.
            }

            if (pq.size() == k) {  // pq 사이즈가 k와 같은 경우
                // pairs 자체가 pair[0] 내림차순으로 정렬되어 있으므로, pq.size() == 3일 때 pair[0]은 최소값이 보장된다.
                res = Math.max(res, totalSum * pair[0]);  // 결과값에 totalSum * nums2의 값들 중 최대값을 저장
            }
        }
        return res;
    }

    @Test
    void test() {
        assertThat(maxScore(new int[]{1, 3, 3, 2}, new int[]{2, 1, 3, 4}, 3)).isEqualTo(12);
        assertThat(maxScore(new int[]{4, 2, 3, 1, 1}, new int[]{7, 5, 10, 9, 6}, 1)).isEqualTo(30);
    }
}
