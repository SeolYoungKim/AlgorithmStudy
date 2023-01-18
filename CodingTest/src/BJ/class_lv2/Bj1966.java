package BJ.class_lv2;

import java.io.*;
import java.util.*;

public class Bj1966 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numberOfTest = Integer.parseInt(br.readLine());
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < numberOfTest; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int numberOfPaper = Integer.parseInt(st.nextToken());
                int idxForCheck = Integer.parseInt(st.nextToken());

                String[] papers = br.readLine().split(" ");
                Queue<Paper> queue = new ArrayDeque<>();
                for (int j = 0; j < papers.length; j++) {
                    queue.add(new Paper(j, Integer.parseInt(papers[j])));
                }

                results.add(check(idxForCheck, queue));
            }

            for (Integer result : results) {
                bw.write(result + "\n");
            }

            bw.flush();
        }
    }

    static int check(int idxForCheck, Queue<Paper> queue) {
        int order = 0;

        outer:
        while (!queue.isEmpty()) {
            Paper paper = queue.poll();
            for (Paper next : queue) {
                if (paper.isLowerThan(next)) {
                    queue.offer(paper);
                    continue outer;
                }
            }

            // 위를 지나오면 자기보다 큰게 없는거고, 출력을 수행함
            order++;  // 출력 순서 증가

            // 출력을 수행할 때 찾던 인덱스와 같은 경우 순서를 리턴함.
            if (paper.isSameIdx(idxForCheck)) {
                break;
            }
        }

        return order;
    }

    static class Paper {
        private final int idx;
        private final int priority;

        public Paper(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

        public boolean isLowerThan(Paper other) {
            return priority < other.priority;
        }

        public boolean isSameIdx(int idxForCheck) {
            return idx == idxForCheck;
        }
    }
}
