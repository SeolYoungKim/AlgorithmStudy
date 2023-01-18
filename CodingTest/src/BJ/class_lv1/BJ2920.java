package BJ.class_lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2920 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();

            String ascending = "1 2 3 4 5 6 7 8";
            String descending = "8 7 6 5 4 3 2 1";

            if (str.contains(ascending)) {
                System.out.println("ascending");
            } else if (str.contains(descending)) {
                System.out.println("descending");
            } else {
                System.out.println("mixed");
            }
        }
    }
}
