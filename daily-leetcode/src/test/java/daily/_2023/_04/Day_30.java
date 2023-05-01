package daily._2023._04;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Day_30 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] rootA = new int[n + 1];
        int[] rootB = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            rootA[i] = i;
            rootB[i] = i;
        }

        int result = 0;  // 합집합이 발생하지 않은 것에 대한 카운트
        int aliceEdges = 0;  // rootA 합집합 카운트
        int bobEdges = 0;  // rootB 합집합 카운트

        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (union(edge[1], edge[2], rootA)) {  // 합집합을 수행했다면
                    aliceEdges++;  // rootA를 합집합을 적용하고 aliceEdge 카운트를 1 증가
                    if (union(edge[1], edge[2], rootB)) {
                        bobEdges++;  // rootB를 합집합을 적용하고 bobEdge 카운트를 1 증가
                    }
                } else {  // 합집합을 수행하지 않은 경우(즉, 이미 합집합이 되어있는 경우)
                    result++;  // result 증가
                }
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (union(edge[1], edge[2], rootA)) {  // 이미 합집합이 수행된 쌍이라면 -> 굳이 없어도 되는 edge
                    aliceEdges++;
                } else {
                    result++;  // 굳이 없어도 되는 edge의 개수를 센다
                }
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (union(edge[1], edge[2], rootB)) {
                    bobEdges++;
                } else {
                    result++;
                }
            }
        }

        return (aliceEdges == bobEdges && aliceEdges == n - 1) ? result : -1;
    }

    private boolean union(final int a, final int b, final int[] root) {
        int rootA = find(a, root);
        int rootB = find(b, root);

        if (rootA == rootB) {
            return false;  // 이미 합집합이 되어있다면 합집합을 수행하지 않았으므로 false 반환
        }

        root[rootA] = rootB;
        return true;
    }

    private int find(final int num, final int[] root) {
        if (root[num] != num) {
            root[num] = find(root[num], root);
        }

        return root[num];
    }

    @Test
    void test() {
        assertThat(maxNumEdgesToRemove(4, new int[][]{{3, 2, 3}, {1, 1, 2}, {2, 3, 4}}))
                .isEqualTo(-1);
    }
}
