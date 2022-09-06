package BJ.기본문제.baekjoon1;

import java.io.*;
import java.util.ArrayList;

public class Bj15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            result.add(Integer.parseInt(s[0]) + Integer.parseInt(s[1]));
        }

        for (Integer integer : result) {
            bw.write(integer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
