package daily._2023._06;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day_09 {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (target < letter) {
                return letter;
            }
        }

        return letters[0];
    }

    @Test
    void test() {
        assertThat(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a')).isEqualTo('c');
        assertThat(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c')).isEqualTo('f');
        assertThat(nextGreatestLetter(new char[]{'x', 'x', 'y', 'y'}, 'z')).isEqualTo('x');
    }
}
