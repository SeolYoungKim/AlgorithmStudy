package LeetCode.hashtable.easy;

import java.util.HashMap;

/**
 * Number Of Good Pairs
 */
public class L1512 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        // 숫자 - count (k - v)
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        int count = 0;
        for (Integer value : map.values()) {
            count += (value * (value - 1) / 2);
        }

        return count;

        // 경우의 수
        // 같은 숫자가 N개 있을 때, (x, y)를 만드는 경우의 수(단, (2, 3) == (3, 2)는 같은 경우이기 때문에 2로 나눔)
        // N * (N - 1) / 2
    }
}

