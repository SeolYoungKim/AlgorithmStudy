package LeetCode.hashtable.easy;

import java.util.HashMap;

public class L169 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(method(nums));
    }

    public static int method(int[] nums) {
        // arr size = n
        // 주요 element = n/2번 초과하여 나타나는 숫자
        // 주요 element는 항상 존재

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        int size = nums.length / 2;

        for (Integer key : map.keySet()) {
            if (map.get(key) > size) {
                return key;
            }
        }

        return -1;
    }
}
