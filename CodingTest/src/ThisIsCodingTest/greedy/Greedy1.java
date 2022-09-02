package ThisIsCodingTest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();
        String[] strings = readLine.split(" ");

        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);

        int count = 0;

        while (n != 1) {
            if (n % k == 0 && k > 1) {
                count += 1;
                n = n / k;
            } else {
                n -= 1;
                count += 1;
            }
        }

        System.out.println("after count = " + count);
    }
}
