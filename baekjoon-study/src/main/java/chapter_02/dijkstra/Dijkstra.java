package chapter_02.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    static List<List<Node>> nodes;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) {
        nodes = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            nodes.add(new ArrayList<>());
        }

        nodes.get(1).add(new Node(2, 8));
        nodes.get(1).add(new Node(3, 3));

        nodes.get(2).add(new Node(4, 4));
        nodes.get(2).add(new Node(5, 15));

        nodes.get(3).add(new Node(4, 13));

        nodes.get(4).add(new Node(5, 2));

        distance = new int[6];
        distance[1] = 0;
        for (int i = 2; i < 6; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        visited = new boolean[6];
        bfs();

        System.out.println(Arrays.toString(distance));

    }

    static void bfs() {
        final PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        queue.offer(new Node(1, 0));

        while (!queue.isEmpty()) {
            final Node node = queue.poll();
            if (visited[node.value]) {
                continue;
            }

            visited[node.value] = true;

            final List<Node> linkedNodes = nodes.get(node.value);
            for (Node next : linkedNodes) {
                if (!visited[next.value]) {
                    queue.offer(next);

                    distance[next.value] = Math.min(distance[next.value],
                            distance[node.value] + next.weight);
                }
            }
        }

    }


    private static class Node {
        private final int value;
        private final int weight;

        public Node(final int value, final int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
