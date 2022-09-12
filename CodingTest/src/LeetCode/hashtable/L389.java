package LeetCode.hashtable;

import java.util.HashMap;
import java.util.HashSet;

public class L389 {
    public static void main(String[] args) {
        String s = "abcd", t = "abcde";
        System.out.println(method(s, t));
    }

    public static char method(String s, String t) {
        if (s.isEmpty()) {
            return t.charAt(0);
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        char result = '0';

        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for (char c : sArr) {
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }

        for (char c : tArr) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        for (Character key : mapT.keySet()) {
            if (!mapS.containsKey(key)) {
                result = key;
                break;
            } else {
                if (!mapT.get(key).equals(mapS.get(key))) {
                    result = key;
                    break;
                }
            }
        }

        return result;
    }

}
