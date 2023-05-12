package daily._2023._05;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Day_12 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int point = questions[i][0];  // 점수
            int jump = questions[i][1];  // 스킵하는 칸의 개수

            int nextQuestion = Math.min(n, i + jump + 1);  // 다음 블록이 있는지 or 없는지. 없으면 n=question.length가 된다.
            dp[i] = Math.max(dp[i + 1], point + dp[nextQuestion]);  // 이전 블록의 점수 합 vs 지금 블록의 점수 + 지금 블록에서 갈 수 있는 다음 블록의 점수
        }
        return dp[0];  // 마지막 값
    }

    @Test
    void test() {
        assertThat(mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}))
                .isEqualTo(5);

        assertThat(mostPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}))
                .isEqualTo(7);
    }
}
