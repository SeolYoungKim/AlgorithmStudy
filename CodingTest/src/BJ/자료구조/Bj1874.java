package BJ.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj1874 {
    public static void main(String[] args) throws IOException {
        // 스택에 푸쉬하면서 스택에 원하는 숫자가 있으면, 팝으로 다시 꺼내와서 결과에 넣음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N];

        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(br.readLine());
        }


        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        int index = 0;
        int count = 1;
        boolean flag = true;

        while (index != line.length) {
            if (stack.isEmpty()) {
                stack.push(count);
                sb.append("+\n");
                count++;
                continue;
            }

            if (line[index] != stack.peek()) {
                stack.push(count);
                sb.append("+\n");
                count++;
            } else {
                stack.pop();
                sb.append("-\n");
                index++;
            }

            if (count > N + 1 && !stack.isEmpty()) {
                flag = false;
                break;
            }

        }

        if (flag) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

    }
}
