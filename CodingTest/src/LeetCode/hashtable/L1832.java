package LeetCode.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  Check if the Sentence Is Pangram
 */
public class L1832 {
    public static void main(String[] args) {
        boolean ans = method("thequickbrownfoxjumpsoverthelazydog");
        System.out.println(ans);
    }

    public static boolean method(String sentence) {
//        String DEFAULT_SENTENCE = "abcdefghijklmnopqrstuvwxyz";
//
//        if (sentence.length() >= 26) {
//
//            String[] split = sentence.split("");
//            HashSet<String> set = new HashSet<>(Arrays.asList(split));
//
//            // 문자열은 변경이 되는 것 처럼 보이나, 사실은 변경이 안되므로 스트링 빌더 사용.
//            StringBuilder sb = new StringBuilder();
//            for (String s : set) {
//                sb.append(s);
//            }
//
//            return DEFAULT_SENTENCE.contentEquals(sb);
//        }
//        return false;

        if (sentence.length() < 26) {
            return false;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (sentence.indexOf(c) < 0) {  // 하나라도 없으면 false
                return false;
            }
        }

        return true;
    }
}
