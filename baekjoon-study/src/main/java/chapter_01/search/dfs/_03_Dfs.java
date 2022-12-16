package chapter_01.search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 13023번 "친구 관계 파악하기"
 */
public class _03_Dfs {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            visited = new boolean[n];
            Arrays.fill(visited, false);

            arrive = false;

            graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken());
                int linkedNode = Integer.parseInt(st.nextToken());

                graph.get(node).add(linkedNode);
                graph.get(linkedNode).add(node);
            }

            for (int i = 0; i < n; i++) {
                dfs(i, 1);
                if (arrive) {
                    break;
                }

                Arrays.fill(visited, false);
            }

            if (arrive) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }

        }
    }

    static void dfs(int node, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[node] = true;
        List<Integer> linkedNodes = graph.get(node);
        for (Integer linkedNode : linkedNodes) {
            if (!visited[linkedNode]) {
                dfs(linkedNode, depth + 1);
            }
        }

//        visited[node] = false;
    }
}
