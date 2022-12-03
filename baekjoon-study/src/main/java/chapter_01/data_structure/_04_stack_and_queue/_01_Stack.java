package chapter_01.data_structure._04_stack_and_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringJoiner;

public class _01_Stack {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());
            int number = 1;

            Stack<Integer> stack = new Stack<>();
            StringJoiner sj = new StringJoiner("\n");
            for (int i = 0; i < n; i++) {
                int input = Integer.parseInt(br.readLine()); // 4

                if (stack.isEmpty()) {
                    stack.push(number);
                    number++;
                    sj.add("+");
                }

                while (true) {
                    if (n < number) {
                        sj = new StringJoiner("\n");
                        sj.add("NO");
                        break;
                    }

                    if (stack.peek() != input) {
                        stack.push(number);
                        number++;
                        sj.add("+");
                        continue;
                    }

                    if (stack.peek() == input) {
                        stack.pop();
                        sj.add("-");
                        break;
                    }
                }
            }

            System.out.println(sj);
        }
    }
}
