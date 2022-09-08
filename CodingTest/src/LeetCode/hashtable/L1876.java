package LeetCode.hashtable;

import java.util.ArrayList;

public class L1876 {
    public static void main(String[] args) {
        String s = "aababcabc";
        System.out.println(method(s));
    }

    public static int method(String s) {
        ArrayList<String> strArr = new ArrayList<>();
        for (int i = 0; i < s.length() - 2; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i)).append(s.charAt(i + 1)).append(s.charAt(i + 2));

            strArr.add(String.valueOf(sb));
        }

        int count = 0;
        for (String str : strArr) {
            if (str.charAt(0) != str.charAt(1) && str.charAt(1) != str.charAt(2) && str.charAt(0) != str.charAt(2)) {
                count++;
            }
        }

        return count;
    }
}
