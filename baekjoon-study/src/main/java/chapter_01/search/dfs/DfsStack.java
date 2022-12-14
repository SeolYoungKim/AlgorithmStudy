package chapter_01.search.dfs;

import java.util.Stack;

public class DfsStack {
    static boolean[] visited = new boolean[9];

    static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5},
            {1, 2}};

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        stack.push(1);
        visited[1] = true;

        while (!stack.isEmpty()) {
            Integer nodeIdx = stack.pop();

            System.out.print(nodeIdx + " -> ");

            for (int linkedNode : graph[nodeIdx]) {
                if (!visited[linkedNode]) {
                    stack.push(linkedNode);
                    visited[linkedNode] = true;
                }
            }
        }
    }

}
