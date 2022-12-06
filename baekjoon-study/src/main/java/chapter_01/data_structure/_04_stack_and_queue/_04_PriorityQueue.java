package chapter_01.data_structure._04_stack_and_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringJoiner;

public class _04_PriorityQueue {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            Comparator<Integer> comparator = Comparator.comparingInt(Math::abs);
            Comparator<Integer> thenComparator = Comparator.comparingInt(i -> i);
            PriorityQueue<Integer> queue = new PriorityQueue<>(comparator.thenComparing(thenComparator));

            StringJoiner sj = new StringJoiner("\n");
            for (int i = 0; i < n; i++) {
                int input = Integer.parseInt(br.readLine());

                if (input == 0) {
                    if (queue.isEmpty()) {
                        sj.add("0");
                    } else {
                        sj.add(queue.poll() + "");
                    }
                    continue;
                }

                queue.offer(input);
            }

            System.out.println(sj);
        }
    }

}
