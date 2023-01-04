package chapter_01.number_theory.euclide;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _02_Euclid {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long num1 = Long.parseLong(st.nextToken());
            long num2 = Long.parseLong(st.nextToken());

            long large, small;
            if (num1 > num2) {
                large = num1;
                small = num2;
            } else {
                large = num2;
                small = num1;
            }

            long result = gcd(large, small);
            for (int i = 0; i < result; i++) {
                bw.write("1");
            }

            bw.flush();
        }
    }

    static long gcd(long large, long small) {
        long remainder = large % small;
        if (remainder == 0) {
            return small;
        }

        while (true) {
            large = small;
            small = remainder;

            remainder = large % small;
            if (remainder == 0) {
                return small;
            }
        }
    }
}
