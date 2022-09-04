package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();

        String[] strings = readLine.split(" ");
        ArrayList<Integer> intList = new ArrayList<>();

        for (String string : strings) {
            intList.add(Integer.parseInt(string));
        }

        int[] answer = {1, 1, 2, 2, 2, 8};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            result.append(answer[i] - intList.get(i)).append(" ");
        }

        System.out.println(result);
    }
}
