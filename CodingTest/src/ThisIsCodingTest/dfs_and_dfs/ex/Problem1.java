package ThisIsCodingTest.dfs_and_dfs.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 음료수 얼려먹기 문제 - DFS
 */
public class Problem1 {

    public static int n;
    public static int m;
    public static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    // DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
    public static boolean dfs(int x, int y) {
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return false;
        }
        // 현재 노드를 아직 방문하지 않았다면
        if (arr.get(x).get(y) == 0) {
            // 해당 노드 방문 처리
            arr.get(x).set(y, 1);
            // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nms = br.readLine().split(" ");

        ArrayList<String> arrList = new ArrayList<>();

        n = Integer.parseInt(nms[0]);
        m = Integer.parseInt(nms[1]);

        for (int i = 0; i < n; i++) {
            arrList.add(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
            String[] split = arrList.get(i).split("");
            for (int j = 0; j < m; j++) {
                arr.get(i).add(Integer.parseInt(split[j]));
            }
        }

        // 모든 노드(위치)에 대하여 음료수 채우기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치에서 DFS 수행
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }
        System.out.println(result); // 정답 출력

    }
}
