package chapter_01.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 백준 1715번 "카드 정렬하기"
 */
public class _02_Greedy {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
            for (int i = 0; i < n; i++) {
                queue.offer(Integer.parseInt(br.readLine()));
            }

            int result = 0;
            while (queue.size() > 1) {
                Integer first = queue.poll();
                Integer second = queue.poll();

                int sum = first + second;
                result += sum;

                queue.offer(sum);
            }

            System.out.println(result);
        }
    }

}

//    static List<Integer> results = new ArrayList<>();
//    static void fail() throws IOException {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            int n = Integer.parseInt(br.readLine());
//
//            int[] cards = new int[n];
//            for (int i = 0; i < n; i++) {
//                cards[i] = Integer.parseInt(br.readLine());
//            }
//
//            Arrays.sort(cards);
//            // 홀수일 경우
//            int finalSum;
//
//            if (n == 1) {
//                finalSum = 0;
//            } else if (n % 2 != 0) {
//                splitAndSum(cards, 0, n - 2);  // 마지막꺼는 빼둠
//                // 홀수일 경우 results의 값을 다 더하고, 다 더한 값 + 마지막 값을 추가해야 함
//                finalSum = results.stream().mapToInt(i -> i).sum();
//                finalSum += (finalSum + cards[n - 1]);
//
//            } else {
//                //짝수일 경우
//                splitAndSum(cards, 0, n - 1);
//                finalSum = results.stream().mapToInt(i -> i).sum();
//            }
//
//            System.out.println(finalSum);
//        }
//    }
//
//    static void splitAndSum(int[] cards, int leftIdx, int rightIdx) {
//        if (leftIdx == rightIdx) {  // 같을 경우 아무것도 안함
//            return;
//        }
//
//        int mid = (leftIdx + rightIdx) / 2;
//        splitAndSum(cards, leftIdx, mid);  // 첫번째~중간 자름
//        splitAndSum(cards, mid + 1, rightIdx);  // 중간~마지막 자름
//
//        sumAndAddResults(cards, leftIdx, rightIdx);  // 나눠진 값들을 모두 더한걸 results에 추가
//    }
//
//    private static void sumAndAddResults(int[] cards, int leftIdx, int rightIdx) {
//        int sum = 0;
//        for (int i = leftIdx; i <= rightIdx; i++) {
//            sum += cards[i];
//        }
//
//        results.add(sum);
//    }