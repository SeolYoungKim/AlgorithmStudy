package daily._2023._04;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

public class Day_29 {
    private static class Node {
        int value;
        int edge;

        public Node(final int value, final int edge) {
            this.value = value;
            this.edge = edge;
        }
    }

    public boolean[] distanceLimitedPathsExistTimeExceed(int n, int[][] edgeList, int[][] queries) {
        final List<List<Node>> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
        }

        // edgeList -> [a, b, edge]
        // a번째 인덱스에 b값을 가지고 edge를 가진 Node를 보관
        for (int[] edges : edgeList) {
            final int node = edges[0];
            final int linkedNodeValue = edges[1];
            final int edge = edges[2];

            // 만약 이미 있을 경우
            final Node linkedNode = new Node(linkedNodeValue, edge);
            if (!nodes.get(node).isEmpty() && nodes.get(node).contains(linkedNode)) { // 비어있지 않고 이미 이 노드를 가진 경우
                linkedNode.edge = Math.min(edge, linkedNode.edge);
            }

            nodes.get(node).add(new Node(linkedNodeValue, edge));
            nodes.get(linkedNodeValue).add(new Node(node, edge));
        }

        boolean[] visited = new boolean[n];

        // queries -> [start, end, limitEdge]
        // start -> end까지 가는 데 limitEdge보다 작은 곳만 통과할 수 있음.
        // bfs를 이용 해보자

        boolean[] results = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            final int[] query = queries[i];
            final int start = query[0];
            final int end = query[1];
            final int limitEdge = query[2];

            results[i] = bfs(nodes, visited, start, end, limitEdge);
            visited = new boolean[n];
        }

        return results;
    }

    private boolean bfs(final List<List<Node>> nodes, final boolean[] visited, final int start,
            final int end, final int limitEdge) {
        final Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);  // 첫 번째 노드를 먼저 넣는다.

        while (!queue.isEmpty()) {
            final Integer node = queue.poll();  // 노드를 꺼낸다.
            visited[node] = true;  // 노드 방문 처리

            final List<Node> linkedNodes = nodes.get(node);  // 노드와 인접한 노드 목록을 꺼냄
            for (Node linkedNode : linkedNodes) {
                if ((linkedNode.edge < limitEdge) && (!visited[linkedNode.value])) {  // limitEdge 미만인 길만 탐색
                    if (linkedNode.value == end) {  // end랑 같으면
                        // 도착할 수 있는 것이니 탐색을 끝낸다
                        return true;
                    }

                    // end랑 같지 않은 노드면 탐색을 더 이어나가야 하므로 queue에 넣는다
                    queue.offer(linkedNode.value);
                }
            }
        }

        return false;
    }

    private static class Union {
        private final int[] parent;

        public Union(final int n) {
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int num) {
            if (parent[num] == num) {
                return num;  // 루트
            }

            return parent[num] = find(parent[num]);  // 루트를 찾는 여정...
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);

            if (xRoot != yRoot) {
                parent[yRoot] = xRoot;
            }
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        final Union union = new Union(n);
        for (int i = 0; i < queries.length; i++) {
            // start, end, limit, index
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};  // 맨 마지막에 인덱스는 왜 저장했지?
        }

        // 결론적으로, 아래와 같이 정렬을 해야 하는 이유는 순서대로 체크하기 위함이다 (효율적인 측면도 있을 듯)
        // limit1 보다 작은 edge들 먼저 체크 -> index값을 i에 임시 저장 (위치 포인터)
        // limit2 부터는 limit2보다 작은 edge들을 체크하는데 limit1에서 체크된 애들은 체크하지 않아도 됨 -> 반복
        // 만약 순서가 뒤죽박죽이라면 순차적으로 체크가 되질 않음
        Arrays.sort(queries, Comparator.comparingInt(a -> a[2]));  // limit 기준으로 정렬 -> limit을 기준으로, limit보다 작은 edgeList 먼저 연결시킴. limit을 작은 것 부터 봐야 그 다음 limit을 체크할 때 영향을 안끼침
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));  // edge 기준으로 정렬 -> limit보다 작은 edge들이 먼저 union됨 -> 그 다음 limit에서는 이전 limit보다 작았던 edge들은 검사 했으므로, 스킵 가능

        int i = 0;
        boolean[] results = new boolean[queries.length];
        for (int[] query : queries) {
            while (i < edgeList.length && edgeList[i][2] < query[2]) {  // edgeList의 edge가 query의 limit보다 작아야 함 -> 여기서 edgeList의 edge가 query Limit보다 작은것만 확인하기 위해서 정렬했나?
                union.union(edgeList[i][0], edgeList[i][1]);  // 작을 때만 유니온으로 경로를 이음
                i++;  // 정렬을 해서 limit보다 작은 애들은 먼저 연결 -> 그 다음 쿼리에서는 연결이 되지 않은 edgeList부터 시작
            }

            if (union.find(query[0]) == union.find(query[1])) {  // start와 end의 root가 같을 때 -> 경로가 있다는 뜻
                results[query[3]] = true;
            }
        }

        return results;
    }

    @Test
    void test() {
        assertThat(distanceLimitedPathsExist(3,
                new int[][]{{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}},
                new int[][]{{0, 1, 2}, {0, 2, 5}})).isEqualTo(new boolean[]{false, true});

        assertThat(distanceLimitedPathsExist(5,
                new int[][]{{0, 1, 10}, {1, 2, 5}, {2, 3, 9}, {3, 4, 13}},
                new int[][]{{0, 4, 14}, {1, 4, 13}})).isEqualTo(new boolean[]{true, false});
    }
}
