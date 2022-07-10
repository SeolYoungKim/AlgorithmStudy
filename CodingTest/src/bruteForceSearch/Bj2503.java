package bruteForceSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bj2503 {

    static int answerCount = 0;

    static String[] stringToChar(String answer) {

        String[] num = new String[3];

        for (int i = 0; i < 3; i++) {
            num[i] = answer.substring(i, i + 1);
        }

        return num;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<String> allNumList = new ArrayList<>();

        for (int i = 111; i < 1000; i++) {
            allNumList.add("" + i);
        }

        for (int i = 0; i < n; i++) {
            List<String> removed = new ArrayList<>();

            String readLine = br.readLine();
            String[] s = readLine.split(" ");

            String answer = s[0];
            String strike = s[1];
            String ball = s[2];
            String[] toChar = stringToChar(answer);

            /**
             * S3 : 끝
             * B3, S1B2, S2B1 : 숫자 3개가 포함되어 있지 않은 애들은 전부 삭제
             * S2B0, S1B1, S0B2 : 숫자 2개를 조합해서 포함되어있지 않은 애들은 전부 삭제
             * S1B0, S0B1 : 숫자 1개가 포함되어있지 않은 애들은 전부 삭제
             */

            if (strike.equals("3")) {
                System.out.println(1);
                break;
            } else if (ball.equals("3") || ((strike.equals("2")) && ball.equals("1")) || ((strike.equals("1")) && ball.equals("2"))){

                allNumList.removeIf(str ->
                        !(str.contains(toChar[0]) && str.contains(toChar[1]) && str.contains(toChar[2])));

            } else if ((strike.equals("1") && ball.equals("0")) || (strike.equals("0") && ball.equals("1"))){

                allNumList.removeIf(str ->
                        !(str.contains(toChar[0]) || str.contains(toChar[1]) || str.contains(toChar[2])));

            } else if ((strike.equals("1") && ball.equals("1")) || (strike.equals("2") && ball.equals("0")) || (strike.equals("0") && ball.equals("2"))) {

                allNumList.removeIf(str ->
                        !((str.contains(toChar[0]) && str.contains(toChar[1])) || (str.contains(toChar[0]) && str.contains(toChar[2])) || (str.contains(toChar[1]) && str.contains(toChar[2]))));

            }

//            else if (ball.equals("3") || (strike.equals("2") && ball.equals("1")) || (strike.equals("1") && ball.equals("2"))) {
//                String[] toChar = stringToChar(answer);
//                allNumList.removeIf(str -> !(str.contains(toChar[0]) && str.contains(toChar[1]) && str.contains(toChar[2])));
//            } else if (strike.equals("2")) {
//
//            }

        }

        System.out.println(allNumList.size());
    }
}
