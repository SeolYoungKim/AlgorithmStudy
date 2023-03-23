package daily._2023._03;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Day_23_Thu {
    static int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        if (visited[node]) {
            return 0;
        }

        visited[node] = true;
        final List<Integer> linkedNodes = graph.get(node);
        for (Integer linkedNode : linkedNodes) {
            dfs(linkedNode, graph, visited);
        }

        return 1;
    }

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] c : connections) {
            graph.get(c[0]).add(c[1]);
            graph.get(c[1]).add(c[0]);
        }

        // 덩어리를 하나의 컴포넌트로 보는거임
        // dfs를 수행하면 연결된 애들끼리가 컴포넌트고, 1을 리턴함 -> 1개의 컴포넌트가 됨
        final boolean[] visited = new boolean[n];
        int components = 0;
        for (int node = 0; node < n; node++) {
            components += dfs(node, graph, visited);
        }

        return components - 1;  // 컴포넌트 간 연결
    }

    @Test
    void test() {
        assertThat(makeConnected(6, new int[][]{{0, 1}, {0, 2}, {1, 2}, {1, 3}, {4, 5}})).isEqualTo(1);
        assertThat(makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}})).isEqualTo(1);
        assertThat(makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}})).isEqualTo(2);
        assertThat(makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}})).isEqualTo(-1);
    }
}
