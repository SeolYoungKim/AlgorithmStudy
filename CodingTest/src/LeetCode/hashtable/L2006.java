package LeetCode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class L2006 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        int method = method(nums, 1);
        System.out.println("method = " + method);
    }

    public static int method(int[] nums, int k) {
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                if (Math.abs(nums[i] - nums[j]) == k) count++;
//            }
//        }
//
//        return count;

        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            if (map.containsKey(num - k)) {
                res += map.get(num - k);
            }
            if (map.containsKey(num + k)) {
                res += map.get(num + k);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        return res;
    }
}
