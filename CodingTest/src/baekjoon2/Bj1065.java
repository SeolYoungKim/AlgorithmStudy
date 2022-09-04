package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<String> numbers = new ArrayList<>();
        int count = 0;

        for (int i = 1; i <= n; i++) {
            numbers.add(String.valueOf(i));
        }

        for (String number : numbers) {

            if (number.length() < 3) {
                count++;
                continue;
            }

            ArrayList<Integer> intArr = new ArrayList<>();  // 각 자리의 숫자를 모은다.

            for (int i = 0; i < number.length(); i++) {
                intArr.add(number.charAt(i) - '0');
            }

            int firstSub = 0;
            int secondSub = 0;

            boolean flag = true;
            for (int j = 1; j < intArr.size() - 1; j++) {
                firstSub = intArr.get(0) - intArr.get(1);
                secondSub = intArr.get(j) - intArr.get(j + 1);

                if (firstSub != secondSub) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }

        }

        System.out.println(count);

    }
}
