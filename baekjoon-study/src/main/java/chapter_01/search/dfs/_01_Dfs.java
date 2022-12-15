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

            visited = new boolean[n + 1];
            Arrays.fill(visited, false);

            nodes = new ArrayList<>();
            nodes.add(new ArrayList<>());  //index 0번째에 넣음

            for (int i = 0; i < n; i++) {
                nodes.add(new ArrayList<>());  //1부터 시작하기 위해 노드 갯수만큼 넣음
            }

            for (int i = 0; i < m; i++) {  // 에지 개수만큼 반복
                StringTokenizer st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken());
                int linkedNode = Integer.parseInt(st.nextToken());

                nodes.get(node).add(linkedNode);  // 양방향 노드
                nodes.get(linkedNode).add(node);  // 양방향 노드
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        List<Integer> linkedNodes = nodes.get(node);
        for (Integer linkedNode : linkedNodes) {
            if (!visited[linkedNode]) {
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
