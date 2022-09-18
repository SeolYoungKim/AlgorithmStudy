package LeetCode.hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-number-of-balloons/
 */
public class L1189 {
    public static void main(String[] args) {
        String text = "nlaebolko";
        System.out.println(method(text));
    }

    public static int method(String text) {
        // 전부 세고 b, a, l, l, o, o, n 을 개수에 맞게 뺀다. (뺄게 없을 때 까지)
        // b, a, l, o, n이 존재할 때만 로직 수행
        if (!text.contains("b") || !text.contains("a") || !text.contains("l") || !text.contains("o") || !text.contains("n"))
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        int count = 0;

        while (true) {
            Integer bCount = map.get('b');
            Integer aCount = map.get('a');
            Integer nCount = map.get('n');
            Integer lCount = map.get('l');
            Integer oCount = map.get('o');

            if (!(bCount >= 1 && aCount >= 1 && nCount >= 1 && lCount >= 2 && oCount >= 2))
                break;

            map.put('b', bCount - 1);
            map.put('a', aCount - 1);
            map.put('n', nCount - 1);
            map.put('l', lCount - 2);
            map.put('o', oCount - 2);

            count++;
        }

        return count;
    }
}

