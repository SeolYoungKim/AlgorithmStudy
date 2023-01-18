package BJ.class_lv1;

import java.io.*;
import java.util.StringTokenizer;

public class Bj10250 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int testCount = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCount; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int h = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());

                bw.write(assignment(h, w, n) + "\n");
            }

            bw.flush();
        }
    }

    static String assignment(int h, int w, int n) {
        int hCount = n;
        int wCount = 1;

        while (hCount > h) {
            hCount -= h;
            wCount++;
        }

        return hCount + String.format("%02d", wCount);
    }
}
