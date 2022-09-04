package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> arrA = new ArrayList<>();
        ArrayList<Integer> arrB = new ArrayList<>();

        boolean flag = true;

        while (flag) {
            String[] s = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            if (a == 0 && b == 0) {
                flag = false;
            }

            arrA.add(a);
            arrB.add(b);
        }

        for (int i = 0; i < arrA.size(); i++) {
            if (arrA.get(i) == 0 && arrB.get(i) == 0) {
                break;
            }

            System.out.println(arrA.get(i) + arrB.get(i));
        }
    }
}
