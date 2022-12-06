package chapter_01.data_structure._04_stack_and_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 백준 2164 "카드 게임"
 */
public class _03_Queue {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                queue.offer(i);
            }

            int order = n;
            while (queue.size() > 1) {
                //버리고 -> 옮기고 를 순차적으로 어떻게 할것이냐
                queue.poll();
                Integer poll = queue.poll();
                queue.offer(poll);
            }

            System.out.println(queue.poll());
        }
    }
}
