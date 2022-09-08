package LeetCode.hashtable;

import java.util.HashMap;

public class L1748 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(method(nums));
    }

    public static int method(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        int result = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                result += key;
            }
        }

        return result;
    }
}
