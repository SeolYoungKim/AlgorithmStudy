package chapter_02.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 18352번 "특정 거리의 도시 찾기"
 */
public class _01_Graph {
    static int distance;
    static List<List<Integer>> nodes;
    static boolean[] visited;
    static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cityNumber = Integer.parseInt(st.nextToken());
            int edgeNumber = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());
            int startCity = Integer.parseInt(st.nextToken());

            visited = new boolean[cityNumber + 1];
            nodes = new ArrayList<>();
            for (int i = 0; i <= cityNumber; i++) {
                nodes.add(new ArrayList<>());
            }

            for (int i = 0; i < edgeNumber; i++) {
                st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken());
                int linkedNode = Integer.parseInt(st.nextToken());

                nodes.get(node).add(linkedNode);
            }

            dfs(startCity);
            if (results.isEmpty()) {
                bw.write("-1");
            } else {
                results.sort(Comparator.naturalOrder());
                for (Integer result : results) {
                    bw.write(result + "\n");
                }
            }

            bw.flush();
        }
    }

    static void dfs(int root) {
        if (distance == 0) {
            results.add(root);
            return;
        }
        Queue<Integer> queue = new LinkedList<>();

        visited[root] = true;
        queue.offer(root);

        int level = 1;
        while (!queue.isEmpty()) { // 큐가 빌 때 까지
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                if (node == null) {
                    break;
                }

                List<Integer> linkedNodes = nodes.get(node);
                for (Integer linkedNode : linkedNodes) {
                    if (!visited[linkedNode]) {
                        visited[linkedNode] = true;
                        queue.offer(linkedNode);

                        if (level == distance) {
                            results.add(linkedNode);
                        }
                    }
                }
            }

            level++;
        }
    }
}
