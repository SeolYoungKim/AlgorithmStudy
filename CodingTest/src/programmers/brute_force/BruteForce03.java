package programmers.brute_force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO 소수찾기 인데.. 이거 브루트포스 아닌듯;;
 */
public class BruteForce03 {

    public HashSet<String> hashSet;

    public static void main(String[] args) {
        BruteForce03 bruteForce03 = new BruteForce03();
        bruteForce03.solution("17");
    }

    public int solution(String numbers) {
        hashSet = new HashSet<>();
        permutation("", numbers);

        System.out.println(hashSet);

        return 0;
    }

    public void permutation(String prefix, String s) {
        int n = s.length();

        if (n == 0) {
            hashSet.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                String forPrefix = prefix + s.charAt(i);

                String substring1 = s.substring(0, i);
                String substring2 = s.substring(i + 1);

                permutation(forPrefix, substring1 + substring2);
            }
        }
    }
}
