package chapter_01.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _01_Bfs {
    static int n;
    static int m;

    static int[][] maze;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            maze = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                String numbers = br.readLine();
                for (int j = 0; j < m; j++) {
                    maze[i][j] = numbers.charAt(j) - '0';
                }
            }

            bfs();
        }
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        // 시작은 0,0 부터
        visited[0][0] = true;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (maze[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        maze[x][y] = maze[now[0]][now[1]] + 1;  // 이동한 곳의 좌표를 이동 전 좌표 + 1 로 변경 (숫자 증가. 카운트 개념)
                        System.out.println(Arrays.deepToString(maze));

                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }


}
