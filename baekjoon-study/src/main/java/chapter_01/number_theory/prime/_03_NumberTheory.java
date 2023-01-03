package chapter_01.number_theory.prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 백준 1747번 "소수&팰린드롬 수 중에서 최솟값 찾기"
 */
public class _03_NumberTheory {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int maxNum = 1500000;
            int[] numbers = new int[maxNum + 1];
            for (int i = 0; i < maxNum; i++) {
                numbers[i] = i;
            }

            for (int i = 2; i <= Math.sqrt(maxNum); i++) {
                if (numbers[i] == 0) {
                    continue;
                }

                for (int j = i * i; j < numbers.length; j += i) {
                    numbers[j] = 0;
                }
            }

            List<Integer> primes = new ArrayList<>();
            for (int number : numbers) {
                if (1 < number) {
                    primes.add(number);
                }
            }

            List<Integer> palindromes = new ArrayList<>();
            for (Integer prime : primes) {
                String strNum = String.valueOf(prime);
                if (isPalindrome(strNum)) {
                    palindromes.add(prime);
                }
            }

            for (Integer palindrome : palindromes) {
                if (n <= palindrome) {
                    System.out.println(palindrome);
                    break;
                }
            }
        }
    }

    static boolean isPalindrome(String number) {
        int length = number.length();

        int leftIdx = 0;
        int rightIdx = length - 1;

        boolean isPalindrome = true;
        while (leftIdx < rightIdx) {
            char left = number.charAt(leftIdx);
            char right = number.charAt(rightIdx);

            if (left != right) {
                isPalindrome = false;
                break;
            }

            leftIdx++;
            rightIdx--;
        }

        return isPalindrome;
    }
}
