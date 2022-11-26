package programmers.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Sort02 {

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        Sort02 sort02 = new Sort02();
        System.out.println(sort02.solution(numbers));
    }

    public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strArr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        return String.join("", strArr);
    }
}
