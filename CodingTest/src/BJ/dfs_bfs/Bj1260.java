package BJ.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj1260 {

    //TODO: 중복이 너무 많다. 객체 하나 두고 그걸 써보자.
    public static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public static boolean[] visitedDfs;
    public static boolean[] visitedBfs;

    public static StringBuilder dfsResult = new StringBuilder();
    public static StringBuilder bfsResult = new StringBuilder();

    public static void dfs(int x) {
        visitedDfs[x] = true;  // 방문한 노드 방문 처리
        dfsResult.append(x).append(" ");

        // 방문한 곳과 연결된 모든 노드 탐색
        for (int i = 0; i < arr.get(x).size(); i++) {
            Integer y = arr.get(x).get(i);

            if (!visitedDfs[y])
                dfs(y);  //dfs는 재귀를 사용해서 방문한 노드에 진입을 하는게 우선(바로 방문하기 위한 장치)
        }

    }

    public static Queue<Integer> visited = new LinkedList<>();

    public static void bfs(int x) {
        if (!visited.isEmpty()) {
            visited.poll();
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        visitedBfs[x] = true;

        while (!queue.isEmpty()) {  // 해당 노드와 연결된 다른 노드들을 전부 우선 탐색
            Integer poll = queue.poll();
            if (!bfsResult.toString().contains(String.valueOf(x))) {
                bfsResult.append(poll).append(" ");
            }

            for (int i = 0; i < arr.get(x).size(); i++) {
                Integer y = arr.get(x).get(i);
                if (!visitedBfs[y]) {
                    queue.offer(y);
                    visited.offer(y);
                    visitedBfs[y] = true;
                }
            }
        }

        // 탐색한 노드들을 순서대로 방문
        for (Integer integer : visited) {
            bfs(integer);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);  // 정점 수
        int m = Integer.parseInt(s[1]);  // 점을 연결하는 선의 수
        int v = Integer.parseInt(s[2]);  // 탐색을 시작하는 점

        visitedDfs = new boolean[n + 1];
        visitedBfs = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<>());  // 간선으로 연결된 숫자 저장 시, index 에러를 방지하기 위해 1개 더 만듬.
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int left = Integer.parseInt(s1[0]);
            int right = Integer.parseInt(s1[1]);

            if (left == right) {
                continue;
            }

            arr.get(left).add(right);
            arr.get(right).add(left);
        }

        for (ArrayList<Integer> integers : arr) {
            integers.sort(Comparator.naturalOrder());
        }

        dfs(v);
        bfs(v);

        System.out.println(dfsResult);
        System.out.println(bfsResult);
    }
}
