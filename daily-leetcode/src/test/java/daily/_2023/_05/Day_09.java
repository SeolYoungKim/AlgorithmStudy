package daily._2023._05;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

public class Day_09 {
    public List<Integer> spiralOrder1(int[][] matrix) {
        int m = matrix.length - 1, n = matrix[0].length;
        int x = 0, y = 0;
        var list = new ArrayList<Integer>();

        while (true) {
            if (n == 0) {
                break;
            }

            for (var i = 0; i < n; i++, y++) {
                list.add(matrix[x][y]);
            }

            x++;
            y--;
            n--;

            if (m == 0) {
                break;
            }
            for (var i = 0; i < m; i++, x++) {
                list.add(matrix[x][y]);
            }

            y--;
            x--;
            m--;

            if (n == 0) {
                break;
            }

            for (var i = 0; i < n; i++, y--) {
                list.add(matrix[x][y]);
            }

            x--;
            y++;
            n--;

            if (m == 0) {
                break;
            }

            for (var i = 0; i < m; i++, x--) {
                list.add(matrix[x][y]);
            }

            y++;
            x++;
            m--;
        }
        return list;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 0));

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        ans.add(matrix[0][0]);
        matrix[0][0] = 101;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int x = pos.x;
            int y = pos.y;

            for (int k = pos.direction; k < pos.direction + 4; k++) { // k는 최대 4회까지 작동한다. 이는 방향 전환용이다.
                // 방향을 구한다. 방향은 (0,1), (1,0), (0,-1), (-1,0)의 순서로 변함
                int direction = k % 4;

                // 방향으로 좌표 이동
                int xIdx = x + dx[direction];
                int yIdx = y + dy[direction];

                // index 값이 범위를 벗어나는 경우, continue를 수행하고 direction을 변경한다. (방향을 전환)
                if (xIdx < 0 || xIdx >= matrix.length || yIdx < 0 || yIdx >= matrix[0].length) {
                    continue;
                }

                // matrix에 이미 방문한 경우
                if (matrix[xIdx][yIdx] == 101) {
                    continue;
                }

                // 이동한 값을 정답리스트에 집어넣고
                ans.add(matrix[xIdx][yIdx]);
                matrix[xIdx][yIdx] = 101;  // 방문 처리

                queue.add(new Position(xIdx, yIdx, direction));  // 큐에 현재 포지션을 넣는다.
                break;  // for문 종료
            }
        }

        return ans;
    }

    private static class Position {
        int x, y, direction;

        public Position(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    @Test
    void test() {
        assertThat(spiralOrder(
                new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}))
                .isEqualTo(List.of(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10));
    }
}
