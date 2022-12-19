package chapter_01.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1167번 "트리의 지름 구하기"
 */
public class Unknown {
    static int n;
    static int[][] nodes;
    static boolean[] visited;
    static int[] weight;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());

            visited = new boolean[n + 1];
            nodes = new int[n + 1][n + 1];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken());
                while (st.hasMoreTokens()) {
                    int linkedNode = Integer.parseInt(st.nextToken());
                    if (linkedNode == -1) {
                        break;
                    }
                    int weight = Integer.parseInt(st.nextToken());
                    nodes[node][linkedNode] = weight;
                }
            }

//            for (int i = 0; i < n; i++) {
//                String numbers = br.readLine();
//                int node = numbers.charAt(0) - '0';
//                for (int j = 2; j < numbers.length(); j += 4) {
//                    char linkedNode = numbers.charAt(j);
//                    if (linkedNode == '-') {
//                        break;
//                    }
//                    int weight = numbers.charAt(j + 2) - '0';
//                    nodes[node][linkedNode - '0'] = weight;
//                }
//            }
//            for (int i = 0; i < n; i++) {
//                String[] edge = br.readLine().split(" ");
//                int node = Integer.parseInt(edge[0]);
//                for (int j = 1; j < edge.length; j += 2) {
//                    int linkedNode = Integer.parseInt(edge[j]);
//                    if (linkedNode != -1) {
//                        nodes[node][linkedNode] = Integer.parseInt(edge[j + 1]);
//                    }
//                }
//            }

            weight = new int[n + 1];
            dfs(1);
//            System.out.println(Arrays.stream(weight).filter(i -> i != 0).sum());
            System.out.println(sum);
        }
    }

    static int sum = 0;
    static void dfs(int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        int[] linkedNodes = nodes[node];
        for (int i = 1; i <= n; i++) { // i == node
            int linkedNodeWeight = linkedNodes[i];
            if (!visited[i] && linkedNodeWeight != 0) {
                weight[node] = Math.max(weight[node], linkedNodeWeight);
                dfs(i);
            }
        }

        sum += weight[node];
    }
}
//5
//1 3 2 -1
//2 4 4 -1
//3 1 2 4 3 -1
//4 2 4 3 3 5 6 -1
//5 4 6 -1