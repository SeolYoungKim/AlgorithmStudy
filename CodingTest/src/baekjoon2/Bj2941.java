package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String readLine = br.readLine();

        String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String replace = readLine;
        for (String s : alpha) {
            if (readLine.contains(s)) {
                replace = replace.replace(s, "_");
            }
        }

        System.out.println(replace.length());
    }
}
