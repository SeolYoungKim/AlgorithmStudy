package LeetCode.hashtable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/
 * TODO:다시풀어
 */

public class L1636 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};
        System.out.println(Arrays.toString(method(nums)));
    }

    public static int[] method(int[] nums) {
        // 내가푼거아님 제출도 아직 안했음
        Map<Integer, Integer> map = new HashMap<>();
        // count frequency of each number
        Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));  // 카운트를 map안에 넣음
        // custom sort
        return Arrays.stream(nums).boxed()
                .sorted((a,b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)  // 카운트가 다르면, 카운트 기준으로 정방향으로 sort. 같으면 값 기준으로 역방향 sort.
                .mapToInt(n -> n)
                .toArray();
    }
}
