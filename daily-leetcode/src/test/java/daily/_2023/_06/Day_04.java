package daily._2023._06;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class Day_04 {
    public int findCircleNum(int[][] isConnected) {
        final int n = isConnected.length;

        final int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {  // 자기 자신이 아닌 경우만 체크
                    if (isConnected[i][j] == 1) {  // 1인 경우만 합집합
                        union(i, j, parents);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            find(i, parents);
        }

        return (int) Arrays.stream(parents)
                .distinct()
                .count();
    }

    private void union(final int a, final int b, final int[] parents) {
        final int rootA = find(a, parents);
        final int rootB = find(b, parents);

        if (rootA != rootB) {
            parents[rootB] = rootA;
        }
    }

    private int find(int num, final int[] parents) {
        if (num == parents[num]) {
            return num;
        }

        return parents[num] = find(parents[num], parents);
    }

    @Test
    void test() {
        assertThat(findCircleNum(new int[][]{
                {1, 1, 0},  // 0번째 node가 1번째 노드와는 연결, 2번째 노드와는 연결 x
                {1, 1, 0},  // 1번째 node가 0번째 노드와는 연결, 2번째 노드와는 연결 x
                {0, 0, 1}   // 2번째 node가 모든 노드와 연결 x
        })).isEqualTo(2);

        assertThat(findCircleNum(new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        })).isEqualTo(3);
    }
}
