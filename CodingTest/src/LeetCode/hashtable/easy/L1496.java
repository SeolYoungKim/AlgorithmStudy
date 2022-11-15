package LeetCode.hashtable.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/path-crossing/
 */

public class L1496 {
    public static void main(String[] args) {
        String path = "NES";
        System.out.println(method(path));
    }

    public static boolean method(String path) {
        char[] chars = path.toCharArray();

        HashSet<String> set = new HashSet<>();
        set.add(0 + ", " + 0);

        int x = 0;
        int y = 0;

        for (char c : chars) {

            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }

            if (!set.add(x + ", " + y))
                return true;

        }

        return false;
    }

}
