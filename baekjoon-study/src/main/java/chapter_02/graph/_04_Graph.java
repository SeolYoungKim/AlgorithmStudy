package chapter_02.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2251번 "물의 양 구하기"
 */
public class _04_Graph {
    // 갈 수 있는 경우의 수
    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};

    static boolean[][] visited;
    static boolean[] answer;

    static int[] bucketSize;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            bucketSize = new int[3];
            bucketSize[0] = Integer.parseInt(st.nextToken());
            bucketSize[1] = Integer.parseInt(st.nextToken());
            bucketSize[2] = Integer.parseInt(st.nextToken());

            visited = new boolean[201][201];
            answer = new boolean[201];
            bfs();

            for (int i = 0; i < answer.length; i++) {
                if (answer[i]) {
                    System.out.println(i + " ");
                }
            }
        }
    }

    static void bfs() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));

        visited[0][0] = true;  // a, b 무게 쌍을 기준으로 방문 판단. a와 b 버켓에 물이 0만큼 있을 때 방문 처리
        answer[bucketSize[2]] = true;  // a, b가 0일 때 c의 무게가 결과값에 포함 됨

        while (!queue.isEmpty()) {
            AB poll = queue.poll();
            int aWeight = poll.a;
            int bWeight = poll.b;
            int cWeight = bucketSize[2] - aWeight - bWeight;  // 전체 물 양 - aWeight - bWeight

            for (int i = 0; i < 6; i++) {  // 여섯가지 경우의 수 판단
                int[] next = {aWeight, bWeight, cWeight};
                next[receiver[i]] += next[sender[i]]; // 받는 물통에 보내려는 물통의 값 더하기
                next[sender[i]] = 0;

                if (next[receiver[i]] > bucketSize[receiver[i]]) {  //물이 넘친 경우. 받는 쪽이 버켓 사이즈보다 큰 값을 받아버린 경우
                    //초과하는 만큼 이전 물통에 넣어줌
                    next[sender[i]] = next[receiver[i]] - bucketSize[receiver[i]];
                    next[receiver[i]] = bucketSize[receiver[i]];
                }

                if (!visited[next[0]][next[1]]) { // 물을 옮기고 난 후의 a, b 무게 쌍을 방문했는지 체크. 방문 안했으면
                    visited[next[0]][next[1]] = true;  // 방문 처리
                    queue.offer(new AB(next[0], next[1]));  // 큐에 무게 쌍을 넣음
                    if (next[0] == 0) {  // a 버켓에 물이 0일 경우, c 버켓의 양을 체크해서
                        answer[next[2]] = true;  // 결과에 넣음
                    }
                }
            }
        }
    }

    // A와 B의 값만 가지고 있으면 C는 유추할 수 있음
    static class AB {
        int a;
        int b;

        public AB(final int a, final int b) {
            this.a = a;
            this.b = b;
        }
    }
}
