package coding_test_company.zcompany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.Comparator.comparingInt;

public class Test {
    public static void main(String[] args) {
//        int[] results = solution2(new int[][]{
//                {1, 0, 3},
//                {2, 1, 3},
//                {3, 3, 2},
//                {4, 9, 1},
//                {5, 10, 2}
//        });
//
//        System.out.println(Arrays.toString(results));

        int[] results = solution4(new int[][]{
                {2, 1, 1, 3, 5, 1},
                {1, 1, 3, 3, 5, 5},
                {8, 3, 3, 3, 1, 5},
                {3, 3, 3, 4, 4, 4},
                {3, 3, 4, 4, 4, 4},
                {1, 4, 4, 4, 4, 4}
        });

        System.out.println(Arrays.toString(results));
    }

    public static long solution1(long n) {
        // 나머지는 n을 넘을 수 없음
        // 나머지는 1~(n-1)
        List<Long> remains = new ArrayList<>();
        for (long i = 1; i < n; i++) {
            remains.add(i);  // 나머지 경우 저장
        }

        // 몫이 나머지와 같을 경우는 (n*나머지) + 나머지 인 수
        return remains.stream()
                .mapToLong(remain -> (remain * n) + remain)
                .sum();
    }

    public static int[] solution2(int[][] data) {
        List<Print> prints = new ArrayList<>();
        for (int[] datum : data) {
            prints.add(new Print(datum[0], datum[1], datum[2]));
        }

        PriorityQueue<Print> queue = new PriorityQueue<>(comparingInt(Print::pageCount)
                .thenComparing(Print::number));

        queue.offer(prints.get(0));

        int printIdx = 1;
        int currentTime = prints.get(0).requestTime();
        List<Integer> results = new ArrayList<>();
        while (!queue.isEmpty()) {
            Print currPrint = queue.poll();
            int printTime = currPrint.pageCount();

            results.add(currPrint.number());

            // 현재 시간이 11이면 다음 출력물은 12부터 출력함.
            // 결국 대기해야 하는 총 시간은 현재 시간 + 출력물 페이지 수 + 1이 됨
            int waitTime = currentTime + printTime + 1;

            // 출력 대기 시간보다 요청 시간이 작은 프린트물을 큐에 추가
            for (int i = printIdx; i < prints.size(); i++) {
                Print print = prints.get(printIdx);
                if (print.requestTime() <= waitTime) {
                    queue.offer(print);
                    printIdx++;
                }
            }

            // 현재 시간을 출력 완료 시점으로 변경.
            currentTime = waitTime;
        }

        return results.stream().mapToInt(i -> i).toArray();
    }

    static class Print {
        private final int number;
        private final int requestTime;
        private final int pageCount;

        public Print(int number, int requestTime, int pageCount) {
            this.number = number;
            this.requestTime = requestTime;
            this.pageCount = pageCount;
        }

        public int number() {
            return number;
        }

        public int requestTime() {
            return requestTime;
        }

        public int pageCount() {
            return pageCount;
        }

        @Override
        public String toString() {
            return "Print{" +
                    "number=" + number +
                    ", requestTime=" + requestTime +
                    ", pageCount=" + pageCount +
                    '}';
        }
    }


    public static int solution3(int[] histogram) {
        int leftIdx = 0;
        int lastIdx = histogram.length - 1;
        int result = Integer.MIN_VALUE;

        // 왼쪽 인덱스는 고정 후, 오른쪽 인덱스를 줄여가며 넓이를 구한다.
        while (leftIdx < histogram.length - 1) {
            for (int rightIdx = lastIdx; rightIdx > leftIdx + 1; rightIdx--) {  // left 인덱스보다 2 큰 값까지만 확인한다.
                int width = rightIdx - leftIdx - 1;
                int height = Math.min(histogram[leftIdx], histogram[rightIdx]);

                result = Math.max(result, width * height);
            }

            leftIdx++;
        }

        return result;
    }

    public static int[] solution4(int[][] grid) {
        // 1부터 grid 길이(행, 열 중에서 짧은 쪽이 최대 마름모 크기가 될 수 있다.)만큼 마름모를 찾는다
        int xAxisLength = grid.length;
        int yAxisLength = grid[0].length;
        int possibleMaximumLength = Math.max(xAxisLength, yAxisLength);  // 가능한 최대 마름모 길이

        // grid 길이 최대 700 -> n^2 -> 490000 -> 브루트 포스 사용 가능.
        // 2 이상의 마름모가 없는 경우, 1이 최대길이다.
        int maxLength = 1;
        for (int length = 2; length < possibleMaximumLength; length++) {
            // 길이 별로 마름모가 있는지 찾고, 있다면 최대값을 갱신한다.
            if (hasRhombus(grid, length)) {
                maxLength = Math.max(maxLength, length);
            }
        }

        // 최대 길이에 대한 마름모 개수를 탐색한다.


        int[] answer = {};
        return answer;
    }

    static boolean hasRhombus(int[][] grid, int length) {
        // length X (length * 2 - 1) 행렬  :  가로로 누운 마름모
        // 3 X 5일 경우
        int yLength = grid[0].length;
        int width = length * 2 - 1;  // 5
        for (int i = 0; i <= grid.length - length; i++) {
            int topIdx = i;
            int bottomIdx = i + length - 1;
            for (int j = 0; j < yLength - width; j++) {
                // (0,0) ~ (2,4)까지 자른 배열에 마름모가 있는지 본다
                int leftIdx = j;
                int rightIdx = j + width - 1;

                // 마름모가 있는지 확인하는 방법..?

            }
        }

        // length X (length * 2 - 1) 행렬  : 세로로 서있는 마름모
        return true;
    }

}
