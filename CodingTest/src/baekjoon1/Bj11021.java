package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            results.add(Integer.parseInt(s[0]) + Integer.parseInt(s[1]));
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Case #%d: %d%n",i + 1 , results.get(i));
        }
    }
}
