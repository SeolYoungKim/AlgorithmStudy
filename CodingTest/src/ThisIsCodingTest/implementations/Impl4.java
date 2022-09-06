package ThisIsCodingTest.implementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 문자열 재정렬
 */
public class Impl4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();

        System.out.println("실행 전 >>> " + LocalDateTime.now());

        ArrayList<Character> charList = new ArrayList<>();
        int total = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < readLine.length(); i++) {
            char c = readLine.charAt(i);

            if (c <= '9') {
                total += (c - '0');
            } else {
                charList.add(c);
            }
        }

        Collections.sort(charList);

        for (Character character : charList) {
            result.append(character);
        }

        result.append(total);

        System.out.println("result = " + result);

        System.out.println("실행 후 >>> " + LocalDateTime.now());

    }
}
