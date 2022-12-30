package chapter_01.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1541번 "잃어버린 괄호"
 * 100-40+50+74-30+29-45+43+11
 * 100+40+50-40+50+74-30+29-45+43+11
 * -100-40+50+74-30+29-45+43+11
 * -100+40-40+50+74-30+29-45+43+11
 * 문제 제대로 안읽은 대표적인 예시 ㅋㅋ
 */
public class _05_Greedy {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String operation = br.readLine();
            String[] numbers = operation.split("-");

            // 첫번째 값 처리
            int result = 0;
            for (int i = 0; i < numbers.length; i++) {
                String[] split = numbers[i].split("\\+");
                int temp = 0;
                for (String s : split) {
                    temp += Integer.parseInt(s);
                }

                if (i == 0) {
                    result += temp;
                } else {
                    result -= temp;
                }
            }

            System.out.println(result);
        }
    }
}
