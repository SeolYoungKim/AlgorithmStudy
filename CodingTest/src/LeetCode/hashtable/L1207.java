package LeetCode.hashtable;

import java.util.*;

public class L1207 {
    public static void main(String[] args) {
        int[] arr = {26,2,16,16,5,5,26,2,5,20,20,5,2,20,2,2,20,2,16,20,16,17,16,2,16,20,26,16};
        System.out.println(method(arr));
    }

    public static boolean method(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        for (Integer value : map.values()) {
            if (!set.isEmpty() && set.contains(value)) {
                return false;
            }

            set.add(value);
        }

        return true;
    }
}
