package daily._2023._06;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Day_04 {
    public int findCircleNum(int[][] isConnected) {
        final int n = isConnected.length;
        final UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {  // 자기 자신이 아닌 경우만 체크
                    if (isConnected[i][j] == 1) {  // 1인 경우만 합집합
                        unionFind.union(i, j);
                    }
                }
            }
        }

        return unionFind.count();
    }

    private static class UnionFind {
        private int count;
        private int[] parents;

        public UnionFind(final int count) {
            this.count = count;
            this.parents = new int[count];

            for (int i = 0; i < count; i++) {
                parents[i] = i;
            }
        }

        private void union(final int a, final int b) {
            final int rootA = find(a);
            final int rootB = find(b);

            if (rootA != rootB) {
                parents[rootB] = rootA;
                count--;
            }
        }

        private int find(int num) {
            if (num == parents[num]) {
                return num;
            }

            return parents[num] = find(parents[num]);
        }

        public int count() {
            return count;
        }
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
