package chapter_02.dijkstra;

import static java.util.Comparator.comparingInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 1916번
 */
public class _02_Dijkstra {
    static List<List<Node>> nodes = new ArrayList<>();
    static boolean[] visited;
    static int[] minFee;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int nodeCounts = Integer.parseInt(br.readLine());
            final int edgeCounts = Integer.parseInt(br.readLine());

            // 필요한 것들 초기화
            visited = new boolean[nodeCounts + 1];

            for (int i = 0; i <= nodeCounts; i++) {
                nodes.add(new ArrayList<>());
            }

            minFee = new int[nodeCounts + 1];
            Arrays.fill(minFee, Integer.MAX_VALUE - 1);

            // 도시 데이터 정리
            for (int i = 0; i < edgeCounts; i++) {
                final StringTokenizer st = new StringTokenizer(br.readLine());
                final int node = Integer.parseInt(st.nextToken());
                final int linkedNode = Integer.parseInt(st.nextToken());
                final int fee = Integer.parseInt(st.nextToken());

                nodes.get(node).add(new Node(linkedNode, fee));
            }

            // 출발지와 도착지 입력
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int start = Integer.parseInt(st.nextToken());
            final int end = Integer.parseInt(st.nextToken());

            dijkstra(start);

            System.out.println(minFee[end]);
        }
    }

    private static void dijkstra(int start) {
        final PriorityQueue<Node> queue = new PriorityQueue<>(comparingInt(node -> node.fee));
        queue.offer(new Node(start, 0));  // start 지점의 fee 는 0으로 초기화
        minFee[start] = 0;  // start 지점의 minFee도 0으로 초기화

        while (!queue.isEmpty()) {
            final Node node = queue.poll();
            if (visited[node.value]) {  // 방문했을 경우
                continue;  // 아무것도 안함
            }

            visited[node.value] = true;
            final List<Node> nextNodes = nodes.get(node.value);
            for (Node nextNode : nextNodes) {
                if (!visited[nextNode.value]
                        && minFee[nextNode.value] > minFee[node.value] + nextNode.fee) {  // 방문한적이 없을 때만(즉, 꺼냈던 노드가 아닌경우만!)
                    minFee[nextNode.value] = Math.min(minFee[nextNode.value],
                            minFee[node.value] + nextNode.fee);  // 최소 가격 갱신

                    nextNode.setFee(minFee[nextNode.value]);  // 노드가 가진 비용 갱신
                    queue.offer(nextNode);
                }
            }
        }

    }


    private static class Node {
        private final int value;
        private int fee;

        public Node(final int value, final int fee) {
            this.value = value;
            this.fee = fee;
        }

        public void setFee(final int fee) {
            this.fee = fee;
        }
    }
}
