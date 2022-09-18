package LeetCode.hashtable.easy;

import java.util.HashMap;
import java.util.HashSet;

public class L217 {
    public static void main(String[] args) {

    }

    public static boolean method(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return set.size() != nums.length;
    }
}
