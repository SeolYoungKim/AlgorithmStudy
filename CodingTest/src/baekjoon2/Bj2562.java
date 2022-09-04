package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> intArr = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 9; i++) {
            intArr.add(Integer.parseInt(br.readLine()));
        }

        for (Integer integer : intArr) {
            max = Math.max(max, integer);
        }

        int index = intArr.indexOf(max) + 1;

        System.out.println(max);
        System.out.println(index);
    }
}
