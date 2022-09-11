package LeetCode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class L884 {
    public static void main(String[] args) {
        String s1 = "apple apple", s2 = "banana";
        System.out.println(Arrays.toString(method(s1, s2)));
    }

    public static String[] method(String s1, String s2) {
        String s = s1 + " " + s2;
        // 두 문장을 합쳐서 정확히 한번만 나타나는 단어를 찾아라
        String[] strArr = s.split(" ");

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();

        for (String str : strArr) {
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                arr.add(key);
            }
        }

        String[] results = new String[arr.size()];
        int size = arr.size();

        for (int i = 0; i < size; i++) {
            results[i] = arr.get(i);
        }

        return results;

    }
}
