package daily._2023._05;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;

public class Day_10 {
    public int[][] generateMatrix(int n) {
        final int[][] result = new int[n][n];
        final boolean[][] visited = new boolean[n][n];

        int num = 1;
        final Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 0));

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        result[0][0] = num;
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            final Position pos = queue.poll();
            final int x = pos.x;
            final int y = pos.y;

            for (int k = pos.direction; k < pos.direction + 4; k++) {
                int direction = k % 4;

                final int xIdx = x + dx[direction];
                final int yIdx = y + dy[direction];


                if (xIdx < 0 || xIdx >= n || yIdx < 0 || yIdx >= n) {
                    continue;
                }

                if (visited[xIdx][yIdx]) {
                    continue;
                }

                num++;
                result[xIdx][yIdx] = num;
                visited[xIdx][yIdx] = true;

                queue.add(new Position(xIdx, yIdx, direction));
                break;
            }
        }

        return result;
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
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }
}
