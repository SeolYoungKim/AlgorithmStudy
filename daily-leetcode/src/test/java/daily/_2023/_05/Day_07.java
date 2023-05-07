package daily._2023._05;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Day_07 {
    /**
     * 1. 길이가 가장 긴, 증가하는 subsequence를 배열에 저장
     * 2. 각 장애물에 대해 이진 탐색 사용 -> subsequence가 저장된 배열에 삽입되어야 하는 위치 탐색 -> 배열 업데이트
     * 3. 결과 배열에 subsequence가 저장된 배열의 길이를 추가
     * ---
     * [ 다이나믹 프로그래밍 문제 ]
     * - 작은 하위 문제로 나누고, 하위 문제에 대한 솔루션을 재사용하여 문제 해결
     * - 각 위치에서 현재 장애물로 끝나는 가장 긴, 증가하는 subsequence를 찾자 -> 저장
     * - 장애물이, 지금까지 만난 장애물보다 큰 경우 subsequence가 저장된 배열의 끝에 추가
     * - 크지 않은경우, 해당 위치의 요소를 현재 장애물로 교체
     *
     */
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int numberOfObstacles = obstacles.length;
        int subSeqLength = 0;

        int[] result = new int[numberOfObstacles];
        int[] increasingSubSeq = new int[numberOfObstacles];

        for (int i = 0; i < numberOfObstacles; i++) {
            int left = 0;
            int right = subSeqLength;
            while (left < right) {
                int mid = (left + right) / 2;
                if (increasingSubSeq[mid] <= obstacles[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            result[i] = left + 1;  // 결과 배열에 카운트를 넣는다.
            if (subSeqLength == left) {
                subSeqLength++;
            }

            increasingSubSeq[left] = obstacles[i];
        }

        return result;
    }

    @Test
    void test() {
        assertThat(longestObstacleCourseAtEachPosition(new int[]{3, 1, 5, 6, 4, 2}))
                .isEqualTo(new int[]{1, 1, 2, 3, 2, 2});
    }
}
