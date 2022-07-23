package baekjoon1;


import java.util.Scanner;

import static java.lang.Integer.*;

public class Bj2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        String b = sc.next();

        String[] c = new String[3];

        for (int i = 0; i < 3; i++) {
            c[i] = b.substring(i, i + 1);
        }

        for (int i = 2; i >= 0; i--) {
            System.out.println(a * parseInt(c[i]));
        }

        System.out.println(a * parseInt(b));
    }
}
