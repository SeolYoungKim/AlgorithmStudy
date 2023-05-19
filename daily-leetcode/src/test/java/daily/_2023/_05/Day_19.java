package daily._2023._05;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day_19 {
    public boolean isBipartite(int[][] graph) {
        final int n = graph.length;
        final int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(final int[][] graph, final int[] colors, final int node, final int color) {
        if (colors[node] != 0) {  // 색이 칠해진 경우
            return colors[node] == color;
        }

        colors[node] = color;  // 처음 칠했을 때는 1로 값을 변경. 다음 노드는 -1, 다음은 1 ...

        for (int neighbor : graph[node]) {
            if (!dfs(graph, colors, neighbor, -color)) {  // 인접한 노드가 서로 같은색이 될 경우
                return false;  // false
            }
        }

        return true;
    }

    @Test
    void test() {
        assertThat(isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}})).isFalse();
        assertThat(isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}})).isTrue();
        assertThat(isBipartite(new int[][]{{4, 1}, {0, 2}, {1, 3}, {2, 4}, {3, 0}})).isFalse();
        assertThat(isBipartite(new int[][]{{4}, {}, {4}, {4}, {0, 2, 3}})).isTrue();
    }
}
