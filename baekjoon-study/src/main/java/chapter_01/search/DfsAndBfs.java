package chapter_01.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * 백준 1260번 "DFS와 BFS 프로그램"
 */
public class DfsAndBfs {
    static List<List<Integer>> nodes;

    static boolean[] visitedForDfs;
    static StringJoiner dfsResult = new StringJoiner(" ");

    static boolean[] visitedForBfs;
    static StringJoiner bfsResult = new StringJoiner(" ");

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int startNode = Integer.parseInt(st.nextToken());

            visitedForDfs = new boolean[n + 1];
            visitedForBfs = new boolean[n + 1];

            nodes = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                nodes.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken());
                int linkedNode = Integer.parseInt(st.nextToken());

                nodes.get(node).add(linkedNode);
                nodes.get(linkedNode).add(node);
            }

            for (List<Integer> node : nodes) {
                node.sort(Comparator.naturalOrder());
            }

            dfs(startNode);
            bfs(startNode);

            System.out.println(dfsResult);
            System.out.println(bfsResult);
        }
    }

    static void dfs(int node) {
        if (visitedForDfs[node]) {
            return;
        }

        visitedForDfs[node] = true;
        dfsResult.add(String.valueOf(node));

        List<Integer> linkedNodes = nodes.get(node);
        for (Integer linkedNode : linkedNodes) {
            if (!visitedForDfs[linkedNode]) {
                dfs(linkedNode);
            }
        }
    }

    static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();

        visitedForBfs[startNode] = true;
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            bfsResult.add(String.valueOf(node));

            List<Integer> linkedNodes = nodes.get(node);

            for (Integer linkedNode : linkedNodes) {
                if (!visitedForBfs[linkedNode]) {
                    visitedForBfs[linkedNode] = true;
                    queue.offer(linkedNode);
                }
            }
        }
    }
}
