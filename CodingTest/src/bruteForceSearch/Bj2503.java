package bruteForceSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj2503 {

    static ArrayList<ArrayList<Integer>> question = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 줄
        int n = Integer.parseInt(br.readLine());

        // 두번째 줄부터 - 대답, S, B
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            question.add(new ArrayList<>());

            for (String s1 : s) {
                question.get(i).add(Integer.parseInt(s1));
            }

        }

        int result = 0;

        for (int i = 123; i < 988; i++) {  // 123부터 987까지의 숫자를 민혁이의 답과 비교한다.
            int hundreds = i / 100;  // 100의자리
            int tens = i / 10 % 10;  // 10의자리
            int units = i % 10;      // 1의 자리

            // 각 자리가 서로 같을 경우, continue로 아래로직을 수행하지 않고, 다시 for문으로 돌아온다.
            if (hundreds == tens || hundreds == units || tens == units) continue;

            // 숫자 0은 사용하지 않으므로 십의자리나 일의자리가 0일 경우 아래 로직을 수행하지 않고, 다시 for문으로 돌아온다.
            if (tens == 0 || units == 0) continue;

            boolean flag = true;  // 중복 카운팅 방지 장치. 아래의 for문이 전부 끝나고 해당 값이 true일 경우에만 result를 1씩 늘림.

            for (ArrayList<Integer> integers : question) {  // 위 for문에서 받아온 숫자를 민혁이의 답과 비교한다.
                int strikeCount = 0, ballCount = 0;

                Integer answer = integers.get(0);
                int hundredsOfAnswer = answer / 100;  // 100의 자리
                int tensOfAnswer = answer / 10 % 10;  // 10의 자리
                int unitsOfAnswer = answer % 10;      // 1의 자리

                Integer strikeAnswer = integers.get(1);
                Integer ballAnswer = integers.get(2);

                if (hundreds == hundredsOfAnswer) strikeCount++;

                if (tens == tensOfAnswer) strikeCount++;

                if (units == unitsOfAnswer) strikeCount++;

                if (hundredsOfAnswer == tens || hundredsOfAnswer == units) ballCount++;

                if (tensOfAnswer == hundreds || tensOfAnswer == units) ballCount++;

                if (unitsOfAnswer == tens || unitsOfAnswer == hundreds) ballCount++;


                if (ballCount != ballAnswer || strikeCount != strikeAnswer) {  // 민혁이의 답의 strike, ball 카운트와 다른 경우 for문을 빠져나간다.
                    flag = false;
                    break;
                }

                // 같은 숫자를 여러번 대답과 비교해서 셀 필요가 없다.
                // 만약에, 345라는 숫자가 들어왔을 때, 민혁이의 대답과 비교하여 S, B의 수를 센다.
                // S, B의 숫자가 민혁이의 S, B와 같으면 그 숫자는 정답이 될 가능성이 있는 숫자이다.
                // 하지만, 로직 상 345라는 숫자는 민혁이의 답 4개와 전부 비교가 될 수 있다.
                // 345가 운이 좋게 민혁이의 대답+S, B 세트와 연속으로 똑같을 가능성이 있다는 것이다.
                // 그럼 하나의 숫자가 4번이나 카운트 될 가능성이 있게 된다. (즉, 중복 카운트)
                // 이를 방지하기 위해, 민혁이의 대답과 전부 비교가 끝난 후에 정답을 카운팅 해야 한다.

                // 또한, 4개를 전부 비교해서 전부 S, B가 같아야 정답 가능성이 있는 숫자라고 할 수 있다.
            }

            if (flag) {  // 민혁이의 답과 비교하는 for문이 성공적으로 끝날 경우에만 result를 1 늘린다.
                result++;
            }
        }

        System.out.println(result);
    }
}
