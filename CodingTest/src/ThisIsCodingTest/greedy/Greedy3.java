package ThisIsCodingTest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Greedy3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] intArr = new int[n];

        String[] strings = br.readLine().split(" ");

        for (String string : strings) {
            System.out.println("string = " + string);
        }

        for (int i = 0; i < n; i++) {
            intArr[i] = Integer.parseInt(strings[i]);
        }

        Arrays.sort(intArr);

        for (int i : intArr) {
            System.out.println("i = " + i);
        }

        int totalTeam = 0;
        int currentTeam = 0;

        for (int i = 0; i < n; i++) {
            currentTeam += 1;
            if (currentTeam >= intArr[i]) {
                totalTeam += 1;
                currentTeam = 0;
            }
        }

        System.out.println("totalTeam = " + totalTeam);

    }
}
