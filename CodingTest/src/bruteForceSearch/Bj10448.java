package bruteForceSearch;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.BufferedReader;

public class Bj10448 {

    static int[] triNum = new int[45];
    static int count = 0;

    static void saveTriNum() {
        for (int i = 0; i < 45; i++) {
            triNum[i] = (i + 1) * (i + 2) / 2;
        } // T1, T2, T3 ... T44
    }

    static void search(int result) {
        count = 0;

        outer:
        for (int i = 0; i < 45; i++) {
            for (int j = 0; j < 45; j++) {
                for (int k = 0; k < 45; k++) {

                    if (result == triNum[i] + triNum[j] + triNum[k]) {
                        count = 1;
                        System.out.println(count);
                        break outer;
                    }
                }
            }
        }

        if (count == 0) {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] intArr = new int[n];

        for (int i = 0; i < n; i++) {
            String readLine = br.readLine();
            intArr[i] = Integer.parseInt(readLine);
        }

        saveTriNum();  // 삼각수 44개 저장

        for (int i = 0; i < n; i++) {  // 숫자가 한개씩 들어옴 10 -> 20 -> 1000
            //10 -> 20 -> 1000 ...
            search(intArr[i]);
        }

    }



}
