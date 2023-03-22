package daily._2023._03;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

public class Day_22_Wed {
    public static int minScore(int n, int[][] roads) {
        // 어쨌든 작은 값을 찾으면 되었던 문제.. 그냥 단순 bfs 문제였다 ...
        // 조건 중에서 어떤 경로를 가든 상관 없댔으니, 전체 경로 중에서 가장 작은 값을 찾기만 하면 됐던 것...
        final List<List<Node>> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            final int node = road[0];
            final int linkedNode = road[1];
            final int dist = road[2];

            nodes.get(node).add(new Node(linkedNode, dist));
            nodes.get(linkedNode).add(new Node(node, dist));
        }

        int result = Integer.MAX_VALUE;

        final boolean[] visited = new boolean[n + 1];
        final Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            final Integer node = queue.poll();

            final List<Node> linkedNodes = nodes.get(node);
            for (Node linkedNode : linkedNodes) {
                if (!visited[linkedNode.val]) {
                    visited[linkedNode.val] = true;
                    queue.offer(linkedNode.val);
                }

                result = Math.min(result, linkedNode.dist);
            }
        }

        return result;
    }

    static class Node {
        private int val;
        private int dist;

        public Node(final int val, final int dist) {
            this.val = val;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", dist=" + dist +
                    '}';
        }
    }


    @Test
    void test() {
        System.out.println(minScore(4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}}));
        System.out.println(minScore(4, new int[][]{{1, 2, 2}, {1, 3, 4}, {3, 4, 7}}));
    }
}
