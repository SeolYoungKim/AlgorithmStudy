package chapter_01.search.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static void main(String[] args) {
        int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};

        boolean[] visited = new boolean[9];

        System.out.println(bfs(1, graph, visited));
    }

    static String bfs(int node, int[][] graph, boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            Integer nodeIdx = queue.poll();
            sb.append(nodeIdx).append(" -> ");

            int[] linkedNodes = graph[nodeIdx];
            for (int linkedNode : linkedNodes) {
                if (!visited[linkedNode]) {
                    visited[linkedNode] = true;
                    queue.offer(linkedNode);
                }
            }
        }

        return sb.toString();
    }
}
