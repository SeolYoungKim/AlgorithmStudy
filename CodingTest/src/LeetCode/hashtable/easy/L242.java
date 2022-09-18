package LeetCode.hashtable.easy;

import java.util.Arrays;

public class L242 {
    public static void main(String[] args) {
        String s = "a", t = "ab";
        System.out.println(method(s, t));
    }

    public static boolean method(String s, String t) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i) - 'a']++;
        }

        System.out.println(Arrays.toString(sCount));
        System.out.println(Arrays.toString(tCount));

        for (int i = 0; i < 26; i++) {
            if (sCount[i] != tCount[i]) {
                return false;
            }
        }

        return true;
    }
}
