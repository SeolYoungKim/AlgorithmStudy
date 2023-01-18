package BJ.class_lv1;

import java.io.*;
import java.util.Arrays;

public class Bj4153 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String outCommand = "0 0 0";
            while (true) {
                String input = br.readLine();
                if (input.equals(outCommand)) {
                    break;
                }

                bw.write(checkRightTriangle(input) + "\n");
            }

            bw.flush();
        }
    }

    static String checkRightTriangle(String input) {
        String[] strings = input.split(" ");
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }

        Arrays.sort(numbers);
        int a = numbers[0];
        int b = numbers[1];
        int c = numbers[2];

        if ((a * a) + (b * b) == (c * c)) {
            return "right";
        }

        return "wrong";
    }
}
