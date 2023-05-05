package daily._2023._05;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.Test;

public class Day_05 {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public int isVowel(final char c) {
        if (VOWELS.contains(c)) {
            return 1;
        }

        return 0;
    }

    public int maxVowels(String s, int k) {
        int max = 0;
        int vowelCount = 0;

        final int length = s.length();
        for (int i = 0; i < length; i++) {
            vowelCount += isVowel(s.charAt(i));

            if (i >= k) {
                vowelCount -= isVowel(s.charAt(i - k));
            }

            max = Math.max(max, vowelCount);
        }

        return max;
    }

    @Test
    void test() {
        assertThat(maxVowels("abciiidef", 3)).isEqualTo(3);
        assertThat(maxVowels("aeiou", 2)).isEqualTo(2);
        assertThat(maxVowels("leetcode", 3)).isEqualTo(2);
    }
}
