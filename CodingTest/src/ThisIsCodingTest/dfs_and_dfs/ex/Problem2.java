package ThisIsCodingTest.dfs_and_dfs.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로 탈출 - BFS
 */
public class Problem2 {

    public static int n, m;
    public static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        // 큐(Queue) 구현을 위해 queue 라이브러리 사용
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        // 큐가 빌 때까지 반복하기
        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽인 경우 무시
                if (arr.get(nx).get(ny) == 0) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (arr.get(nx).get(ny) == 1) {
                    arr.get(nx).set(ny, arr.get(x).get(y) + 1);
                    q.offer(new Node(nx, ny));
                }
            }
        }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return arr.get(n - 1).get(m - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conditions = br.readLine().split(" ");

        n = Integer.parseInt(conditions[0]);
        m = Integer.parseInt(conditions[1]);

        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
            String readLine = br.readLine();

            for (int j = 0; j < m; j++) {
                arr.get(i).add(readLine.charAt(j) - '0');
            }
        }

        System.out.println(bfs(0, 0));

    }
}

class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}