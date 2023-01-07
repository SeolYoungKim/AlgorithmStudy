package chapter_02.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1325번 "효율적인 해킹"
 */
public class _02_Graph {
    static List<List<Integer>> nodes = new ArrayList<>();
    static boolean[] visited;
    static int[] results;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeCounts = Integer.parseInt(st.nextToken());
            int edgeCounts = Integer.parseInt(st.nextToken());

            // 노드 갯수 + 1 만큼 초기화
            visited = new boolean[nodeCounts + 1];
            results = new int[nodeCounts + 1];
            for (int i = 0; i <= nodeCounts; i++) {
                nodes.add(new ArrayList<>());
            }

            // 단방향 그래프. 주어진 값을 반대로. a->b 신뢰 구조가 형성됐을 경우, 탐색은 b->a만 가능하도록
            for (int i = 0; i < edgeCounts; i++) {
                st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken());
                int nextNode = Integer.parseInt(st.nextToken());

                nodes.get(node).add(nextNode);
            }

            // 노드가 10,000개 + 엗지가 100,000개일 경우 dfs 1회당 110,000 * 10,000 (노드개수만큼 탐방) <- 여기서 시간초과 날듯 최대 10억번 돔
            for (int i = 1; i <= nodeCounts; i++) {
                bfs(i);  // 탐색

                // 초기화
                visited = new boolean[nodeCounts + 1];
            }

            // 최대값을 구하고
            int max = Integer.MIN_VALUE;
            for (int result : results) {
                max = Math.max(max, result);
            }

            // 최대값에 해당하는 node를 구함
            for (int i = 1; i <= nodeCounts; i++) {
                if (max == results[i]) {
                    bw.write(i + " ");
                }
            }

            bw.flush();
        }
    }

    static void bfs(int node) {
        visited[node] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            results[currentNode]++;

            List<Integer> linkedNodes = nodes.get(currentNode);
            for (Integer linkedNode : linkedNodes) {
                if (!visited[linkedNode]) {
                    visited[linkedNode] = true;
                    queue.offer(linkedNode);
                }
            }
        }
    }
}
