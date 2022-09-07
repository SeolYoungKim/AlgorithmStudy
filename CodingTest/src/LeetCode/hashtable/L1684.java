package LeetCode.hashtable;

import java.util.*;

/**
 * Count the Number of Consistent Strings
 */
public class L1684 {
    public static void main(String[] args) {
        String allowed = "cad";
        String[] words = {"cc","acd","b","ba","bac","bad","ac","d"};

        int count = count(allowed, words);
        System.out.println("count = " + count);
    }

    public static int count(String allowed, String[] words) {
        int count = 0;
        List<Character> ansChar = new ArrayList<>();

        for (int i = 0; i < allowed.length(); i++) {
            ansChar.add(allowed.charAt(i));
        }

        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (!ansChar.contains(word.charAt(i))) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }

        return count;
    }
}
