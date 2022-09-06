package BJ.기본문제.baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;

public class Bj1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String readLine = br.readLine();

        HashMap<String, Integer> count = new HashMap<>();

        for (int i = 0; i < readLine.length(); i++) {
            String s = String.valueOf(readLine.charAt(i)).toUpperCase();

            if (!count.containsKey(s)) {
                count.put(s, 1);
            } else {
                count.replace(s, count.get(s) + 1);
            }
        }

        String maxKey = null;
        int keyCount = 0;
        int maxValue = Collections.max(count.values());

        for (String s : count.keySet()) {
            if (count.get(s) == maxValue) {
                if (maxKey != null && !s.equals(maxKey)) {
                    keyCount++;
                }
                maxKey = s;
            }
        }

        if (keyCount > 0) {
            System.out.println("?");
        } else {
            System.out.println(maxKey);
        }

    }
}
