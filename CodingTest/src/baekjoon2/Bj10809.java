package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();

        ArrayList<Character> charArr = new ArrayList<>();

        ArrayList<Integer> results = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++) {
            charArr.add(c);
        }

        for (Character character : charArr) {
            if (readLine.contains(String.valueOf(character))) {
                results.add(readLine.indexOf(character));
            } else {
                results.add(-1);
            }
        }

        for (Integer result : results) {
            System.out.print(result + " ");
        }
    }
}
