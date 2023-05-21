package daily._2023._05;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import org.junit.jupiter.api.Test;

public class Day_21 {
    public int shortestBridge(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        final LinkedList<int[]> queue = new LinkedList<>();
        boolean found = false;

        for (int i = 0; i < m; i++) {
            if (found) {
                break;
            }

            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, queue, i, j, dirs);  // 섬1, 2를 쉽게 식별하기 위해 dfs를 이용하여 섬 하나를 찾기
                    found = true;
                    break;
                }
            }
        }

        // 하나의 섬의 좌표들은 모두 queue 안에 들어있다.
        // queue & bfs를 이용하여 하나의 섬을 확장시켜 나가면서 다른 섬과 만나는 경우를 찾음
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int i = curr[0] + dir[0];
                    int j = curr[1] + dir[1];
                    if (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]) {
                        if (grid[i][j] == 1) {  // 다른 섬과 만난 경우
                            return step;
                        }

                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }

            step++;
        }

        return -1;
    }

    private void dfs(final int[][] grid, final boolean[][] visited, final LinkedList<int[]> queue,
            final int i, final int j,
            final int[][] dirs) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        for (int[] dir : dirs) {
            dfs(grid, visited, queue, i + dir[0], j + dir[1], dirs);
        }
    }

    @Test
    void test() {
        assertThat(shortestBridge(new int[][]{{0, 1}, {1, 0}})).isEqualTo(1);
        assertThat(shortestBridge(new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}})).isEqualTo(2);
        assertThat(shortestBridge(new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1}})).isEqualTo(1);
    }
}
