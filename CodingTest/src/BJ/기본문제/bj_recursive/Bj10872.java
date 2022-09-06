package BJ.기본문제.bj_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(recursive(n));
    }

    public static int recursive(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * recursive(n - 1);
    }
}
