package chapter_02.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 1854번
 */
public class _03_Dijkstra {
    static int[][] distances;
    static List<PriorityQueue<Integer>> minDistance = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int nodesCount = Integer.parseInt(st.nextToken());
            final int edgesCount = Integer.parseInt(st.nextToken());
            final int k = Integer.parseInt(st.nextToken());

            distances = new int[nodesCount + 1][nodesCount + 1];
            for (int i = 0; i <= nodesCount; i++) {
                minDistance.add(new PriorityQueue<>(k, Comparator.reverseOrder()));
            }

            for (int i = 0; i < edgesCount; i++) {
                final StringTokenizer input = new StringTokenizer(br.readLine());
                final int node = Integer.parseInt(input.nextToken());
                final int nextNode = Integer.parseInt(input.nextToken());
                final int distance = Integer.parseInt(input.nextToken());

                distances[node][nextNode] = distance;
            }

            final PriorityQueue<Node> queue = new PriorityQueue<>(
                    Comparator.comparingInt(n -> n.distance));

            queue.offer(new Node(1, 0));
            minDistance.get(1).offer(0);

            while (!queue.isEmpty()) {
                final Node curr = queue.poll();
                for (int next = 1; next <= nodesCount; next++) {  // 노드를 전부 돌면서 체크
                    if (distances[curr.value][next] != 0) {
                        final PriorityQueue<Integer> pqOfNext = minDistance.get(next);
                        final int distance = curr.distance + distances[curr.value][next];

                        if (pqOfNext.size() < k) {
                            pqOfNext.offer(distance);
                            queue.offer(new Node(next, distance));

                        } else if (pqOfNext.peek() > distance) {
                            pqOfNext.poll();  // max 값 삭제
                            pqOfNext.offer(distance);
                            queue.offer(new Node(next, distance));
                        }
                    }
                }
            }

            for (int i = 1; i <= nodesCount; i++) {
                if (minDistance.get(i).size() == k) {
                    bw.write(minDistance.get(i).peek() + "\n");
                } else {
                    bw.write("-1\n");
                }
            }

            bw.flush();
        }
    }

    private static class Node {
        private final int value;
        private final int distance;

        public Node(final int value, final int distance) {
            this.value = value;
            this.distance = distance;
        }
    }
}
