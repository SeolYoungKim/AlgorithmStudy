package chapter_01.data_structure._04_stack_and_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _02_Stack {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int[] results = new int[n];
            Stack<Integer> stack = new Stack<>();
            stack.push(0);  // 초기화

            for (int i = 1; i < n; i++) {
                // 스택이 안 비어있고, 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    results[stack.pop()] = numbers[i];
                }

                stack.push(i);
            }

            while (!stack.isEmpty()) {
                results[stack.pop()] = -1;
            }

            for (int result : results) {
                bw.write(result + " ");
            }

            bw.flush();
        }
    }
}
