package ThisIsCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();

        String[] strings = readLine.split("");
        int[] intArr = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            intArr[i] = Integer.parseInt(strings[i]);
        }

        int answer = intArr[0];
        for (int i = 1; i < strings.length; i++) {
            if (answer <= 1 || intArr[i] <= 1) {
                answer += intArr[i];
            } else {
                answer *= intArr[i];
            }
        }

        System.out.println("answer = " + answer);
    }
}
