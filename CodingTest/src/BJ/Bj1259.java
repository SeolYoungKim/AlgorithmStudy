package BJ;

import java.io.*;

public class Bj1259 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String readStr;
            while (true) {
                readStr = br.readLine();

                if (readStr.equals("0")) {
                    break;
                }

                bw.write(checkPalindrome(readStr) + "\n");
            }

            bw.flush();
        }
    }

    static String checkPalindrome(String str) {
        int leftIdx = 0;
        int rightIdx = str.length() - 1;

        while (leftIdx < rightIdx) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                return "no";
            }
            leftIdx++;
            rightIdx--;
        }

        return "yes";
    }
}
