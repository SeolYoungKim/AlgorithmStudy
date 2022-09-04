package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        try {
            while (true) {
                String readLine = br.readLine();

                if (readLine.isEmpty()) {
                    break;
                }

                String[] s = readLine.split(" ");
                a.add(Integer.parseInt(s[0]));
                b.add(Integer.parseInt(s[1]));
            }

        } catch (NullPointerException e) {

        } finally {
            for (int i = 0; i < a.size(); i++) {
                System.out.println(a.get(i) + b.get(i));
            }
        }
    }
}
