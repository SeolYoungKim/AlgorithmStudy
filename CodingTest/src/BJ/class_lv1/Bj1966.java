package BJ.class_lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj1966 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testNumber = Integer.parseInt(br.readLine());
            for (int i = 0; i < testNumber; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int printsNumber = Integer.parseInt(st.nextToken());
                int location = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());
                int[] importances = new int[10];
                for (int j = 0; j < printsNumber; j++) {
                    int prints = Integer.parseInt(st.nextToken());
                }

            }
        }
    }
}
