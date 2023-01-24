package chapter_02.bellman_ford;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 11657번
 */
public class _01_BellmanFord {
    static final int INF = Integer.MAX_VALUE - 1;
    static long[] distance;
    static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int nodeCount = Integer.parseInt(st.nextToken());
            final int edgeCount = Integer.parseInt(st.nextToken());

            distance = new long[nodeCount + 1];
            Arrays.fill(distance, INF);

            for (int i = 0; i < edgeCount; i++) {
                final StringTokenizer input = new StringTokenizer(br.readLine());
                final int node = Integer.parseInt(input.nextToken());
                final int nextNode = Integer.parseInt(input.nextToken());
                final int distance = Integer.parseInt(input.nextToken());

                edges.add(new Edge(node, nextNode, distance));
            }

            bellmanFord(nodeCount, edgeCount);

            if (hasNegativeCycle(edgeCount)) {
                bw.write("-1");
                bw.flush();
                return;
            }

            for (int i = 2; i <= nodeCount; i++) {
                if (distance[i] == INF) {
                    bw.write("-1\n");
                    continue;
                }

                bw.write(distance[i] + "\n");
            }

            bw.flush();
        }
    }

    private static void bellmanFord(int nodeCount, int edgeCount) {
        distance[1] = 0;

        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < edgeCount; j++) {
                final Edge edge = edges.get(j);

                if (distance[edge.from] != INF
                        && distance[edge.to] > distance[edge.from] + edge.distance) {
                    distance[edge.to] = distance[edge.from] + edge.distance;
                }
            }
        }
    }

    private static boolean hasNegativeCycle(int edgeCount) {
        for (int i = 0; i < edgeCount; i++) {
            final Edge edge = edges.get(i);

            if (distance[edge.from] != INF
                    && distance[edge.to] > distance[edge.from] + edge.distance) {
                return true;
            }
        }

        return false;
    }

    private static class Edge {
        private final int from;
        private final int to;
        private final int distance;

        public Edge(final int from, final int to, final int distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }
    }
}
