package BJ.class_lv1;

import java.io.*;

public class BJ2741 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int number = Integer.parseInt(br.readLine());
            for (int i = 1; i <= number; i++) {
                bw.write(i + "\n");
            }

            bw.flush();
        }
    }
}
