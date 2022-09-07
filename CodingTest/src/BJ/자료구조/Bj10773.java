package BJ.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> validation = new Stack<>();

        for (int i = 0; i < N; i++) {
            int token = Integer.parseInt(br.readLine());

            if (token != 0) {
                validation.push(token);
            } else {
                validation.pop();
            }
        }

        int sum = 0;
        for (Integer integer : validation) {
            sum += integer;
        }

        System.out.println(sum);
    }
}
