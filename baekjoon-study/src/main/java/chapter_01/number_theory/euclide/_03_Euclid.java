package chapter_01.number_theory.euclide;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 1033번 "칵테일"
 */
public class _03_Euclid {
    static List<List<Node>> nodes;
    static long lcm;
    static boolean[] visited;
    static long[] result;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());

            nodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nodes.add(new ArrayList<>());
            }

            visited = new boolean[n];
            result = new long[n];
            lcm = 1;

            for (int i = 0; i < n - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());

                nodes.get(a).add(new Node(b, p, q));
                nodes.get(b).add(new Node(a, q, p));
                lcm *= ( p * q / gcd(p, q));
            }

            result[0] = lcm;  // 시작점을 0으로 정하고, 최소공배수를 넣는다.
            dfs(0); // 0부터 탐색한다.
            long mgcd = result[0];
            for (int i = 1; i < n; i++) {
                mgcd = gcd(mgcd, result[i]);
            }

            for (int i = 0; i < n; i++) {
                bw.write(result[i] / mgcd + " ");
            }

            bw.flush();
        }
    }

    private static void dfs(int node) {
        visited[node] = true;

        List<Node> linkedNodes = nodes.get(node);
        for (Node linkedNode : linkedNodes) {
            int next = linkedNode.value;
            if (!visited[next]) {
                result[next] = result[node] * linkedNode.q / linkedNode.p;  // node/next = p/q 이므로 next = node * q / p
                dfs(next);
            }
        }
    }

    private static long gcd(long p, long q) {
        if (q == 0) {
            return p;
        }

        return gcd(q, p % q);
    }

    static class Node {
        int value;
        int p;
        int q;

        public Node(int value, int p, int q) {
            this.value = value;
            this.p = p;
            this.q = q;
        }
    }
}
