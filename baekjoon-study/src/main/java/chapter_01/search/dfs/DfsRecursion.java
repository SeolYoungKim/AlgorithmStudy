package chapter_01.search.dfs;

public class DfsRecursion {
    static boolean[] visited = new boolean[10];

//    static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5},
//            {1, 2}};

//    static int[][] graph = {{}, {2, 5}, {5}, {4}, {6}, {}};  // 연결이 안되면 중간에 끊긴다
    static int[][] graph = {{}, {2, 5}, {5,4,3}, {4}, {6,5}, {}, {}};  //

    public static void main(String[] args) {
        dfs(1);
    }

    static void dfs(int nodeIdx) {
        visited[nodeIdx] = true;

        System.out.print(nodeIdx + " -> ");

        int[] nextNode = graph[nodeIdx];
        for (int node : nextNode) {  // 인접 노드를 순차 방문
            if (!visited[node]) {  // 방문한적이 없으면
                dfs(node);  // 방문 ㄱㄱ
            }
        }
    }
}
