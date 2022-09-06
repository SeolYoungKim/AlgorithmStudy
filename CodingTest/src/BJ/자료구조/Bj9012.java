package BJ.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Bj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> strArr = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            strArr.add(br.readLine());
        }

        outer:
        for (String s : strArr) {
            Stack<Character> chrStack = new Stack<>();

            if (s.charAt(0) == ')') {
                results.add("NO");
                continue;
            }

            for (int i = 0; i < s.length(); i++) {

                if (chrStack.isEmpty()) {
                    chrStack.push(s.charAt(i));
                } else {
                    if (chrStack.firstElement() == ')') {
                        results.add("NO");
                        continue outer;
                    }

                    if (chrStack.peek() == s.charAt(i)) {
                        chrStack.push(s.charAt(i));
                    } else {
                        chrStack.pop();
                    }
                }
            }

            if (chrStack.isEmpty()) {
                results.add("YES");
            } else {
                results.add("NO");
            }

        }

        for (String result : results) {
            System.out.println(result);
        }

    }
}
