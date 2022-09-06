package BJ.기본문제.baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int receipt = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        int result = 0;

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            result += Integer.parseInt(s[0]) * Integer.parseInt(s[1]);
        }

        if (receipt == result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
