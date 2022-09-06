package BJ.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj10828 {
    public static ArrayList<Integer> integers = new ArrayList<>();

    public static void stack(String str) {

        if (str.contains("push")) {
            String[] s = str.split(" ");
            int i = Integer.parseInt(s[1]);
            integers.add(i);

        } else if (str.equals("pop")) {

            if (integers.size() == 0) {
                System.out.println(-1);

            } else {
                int index = integers.size() - 1;
                Integer remove = integers.remove(index);
                System.out.println(remove);
            }

        } else if (str.equals("size")) {
            System.out.println(integers.size());

        } else if (str.equals("empty")) {
            System.out.println(integers.isEmpty() ? 1 : 0);

        } else if (str.equals("top")) {

            if (integers.size() == 0) {
                System.out.println(-1);

            } else {
                int index = integers.size() - 1;
                System.out.println(integers.get(index));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> strArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            strArr.add(br.readLine());
        }

        for (String s : strArr) {
            stack(s);
        }
    }

}
