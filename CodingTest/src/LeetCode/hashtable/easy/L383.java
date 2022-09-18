package LeetCode.hashtable.easy;

import java.util.HashMap;

public class L383 {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(method(ransomNote, magazine));
    }

    public static boolean method(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransom = new HashMap<>();
        HashMap<Character, Integer> maga = new HashMap<>();

        char[] charArr1 = ransomNote.toCharArray();
        char[] charArr2 = magazine.toCharArray();

        for (char c : charArr1) {
            ransom.put(c, ransom.getOrDefault(c, 0) + 1);
        }

        for (char c : charArr2) {
            maga.put(c, maga.getOrDefault(c, 0) + 1);
        }

        boolean result = true;
        for (Character key : ransom.keySet()) {
            result = result && maga.containsKey(key) && maga.get(key) >= ransom.get(key);
        }

        return result;

    }
}
