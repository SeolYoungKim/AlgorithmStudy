package LeetCode.hashtable.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//TODO: 내가푼거 아님.. 나중에 다시 풀어보자.. 배열을 이용한 방법 + char - 'a'를 이용하여 index 0부터 'a'가 할당되도록 한 방법..
public class L1002 {
    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        System.out.println(method(words));
    }

    public static List<String> method(String[] A) {
        List<String> ans = new ArrayList<>();
        // Common characters dictionary
        int[] dict = new int[26];
        for (int j = 0; j < A[0].length(); j++) {
            dict[A[0].charAt(j) - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            // Dictionary of the current word
            int[] curr = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                curr[A[i].charAt(j) - 'a']++;
            }
            // Update the common dictionary
            for (int j = 0; j < 26; j++) {
                if (curr[j] < dict[j]) dict[j] = curr[j];
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < dict[i]; j++) {
                ans.add(Character.toString((char) ('a' + i)));
            }
        }
        return ans;
    }
}
