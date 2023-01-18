package BJ.class_lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2475 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] numbers = br.readLine().split(" ");

            int sum = 0;
            for (String s : numbers) {
                int number = Integer.parseInt(s);
                sum += number * number;
            }

            System.out.println(sum % 10);
        }
    }
}
