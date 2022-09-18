package LeetCode.hashtable.easy;

import java.util.HashMap;

public class L387 {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(method(s));
    }

    public static int method(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] strArr = s.split("");

        for (String str : strArr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int index = Integer.MAX_VALUE;
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                index = Math.min(index, s.indexOf(key));
            }
        }

        if (index == Integer.MAX_VALUE) {
            return -1;
        }

        return index;
    }
}
