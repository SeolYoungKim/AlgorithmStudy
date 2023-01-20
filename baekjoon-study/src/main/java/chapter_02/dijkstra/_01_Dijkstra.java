package chapter_02.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 1753번
 */
public class _01_Dijkstra {
    public static final int INF = Integer.MAX_VALUE - 1;
    static List<List<Node>> nodes;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            final StringTokenizer counts = new StringTokenizer(br.readLine());
            final int nodeCounts = Integer.parseInt(counts.nextToken());
            final int edgeCounts = Integer.parseInt(counts.nextToken());
            final int start = Integer.parseInt(br.readLine());

            nodes = new ArrayList<>();
            for (int i = 0; i <= nodeCounts; i++) {
                nodes.add(new ArrayList<>());
            }

            for (int i = 0; i < edgeCounts; i++) {
                final StringTokenizer st = new StringTokenizer(br.readLine());
                final int node = Integer.parseInt(st.nextToken());
                final int linkedNode = Integer.parseInt(st.nextToken());
                final int weight = Integer.parseInt(st.nextToken());

                nodes.get(node).add(new Node(linkedNode, weight));
            }

            visited = new boolean[nodeCounts + 1];
            distance = new int[nodeCounts + 1];
            Arrays.fill(distance, INF);

            dfs(start);
            for (int i = 1; i <= nodeCounts; i++) {
                if (distance[i] == INF) {
                    bw.write("INF\n");
                } else {
                    bw.write(distance[i] + "\n");
                }
            }
        }
    }

    static void dfs(int start) {
        final PriorityQueue<Node> queue = new PriorityQueue<>(
                Comparator.comparingInt(node -> node.distance));

        queue.offer(new Node(start, 0));
        distance[start] = 0;

        while (!queue.isEmpty()) {
            final Node node = queue.poll();
            if (visited[node.value]) {
                continue;
            }

            visited[node.value] = true;
            final List<Node> nextNodes = nodes.get(node.value);
            for (Node nextNode : nextNodes) {
                if (!visited[nextNode.value]) {
                    distance[nextNode.value] = Math.min(distance[nextNode.value],
                            distance[node.value] + nextNode.distance);

                    nextNode.setDistance(distance[nextNode.value]);
                    queue.offer(nextNode);
                }
            }
        }

    }

    static class Node {
        private final int value;
        private int distance;

        public Node(final int value, final int distance) {
            this.value = value;
            this.distance = distance;
        }

        public void setDistance(final int distance) {
            this.distance = distance;
        }
    }
}
