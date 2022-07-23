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

        for (int i = 123; i < 987; i++) {
            allNumList.add("" + i);
        }

            /**
             * S3 : 끝
             * B3, S1B2, S2B1 : 숫자 3개가 포함되어 있지 않은 애들은 전부 삭제
             * S2B0, S1B1, S0B2 : 숫자 2개를 조합해서 포함되어있지 않은 애들은 전부 삭제
             * S1B0, S0B1 : 숫자 1개가 포함되어있지 않은 애들은 전부 삭제
             */

    }
}
