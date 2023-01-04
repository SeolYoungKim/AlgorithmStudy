package BJ;

import java.io.*;

public class BJ2577 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int mul = 1;
            for (int i = 0; i < 3; i++) {
                int number = Integer.parseInt(br.readLine());
                mul *= number;
            }

            String number = String.valueOf(mul);
            int[] results = new int[10];
            for (int i = 0; i < number.length(); i++) {
                int oneNum = number.charAt(i) - '0';
                results[oneNum]++;
            }

            for (int result : results) {
                bw.write(result + "\n");
            }

            bw.flush();
        }
    }
}
