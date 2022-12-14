package chapter_01.search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _01_Dfs {
    static boolean[] visited;
    static List<List<Integer>> nodes;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());  // 노드 개수
            int m = Integer.parseInt(st1.nextToken());  // 에지 개수

            visited = new boolean[n];
            Arrays.fill(visited, false);

            nodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nodes.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken()) - 1;
                Integer linkedNode = Integer.valueOf(st.nextToken());

                nodes.get(node).add(linkedNode);
            }

            System.out.println(nodes);
            dfs(1);

            System.out.println(Arrays.toString(visited));
        }
    }

    public static void dfs(int value) {
        visited[value - 1] = true;

        System.out.print(value + " ");

        // value에 해당하는 연결 노드들을 가져옴
        List<Integer> linkedNodes = nodes.get(value - 1);
        for (Integer linkedNode : linkedNodes) {
            if (!visited[linkedNode - 1]) {
                dfs(linkedNode);
            }
        }
    }
}
//6 8
//1 2
//2 5
//5 1
//3 4
//4 6
//5 4
//2 4
//2 3
