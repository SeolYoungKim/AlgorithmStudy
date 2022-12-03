package chapter_01.data_structure._03_sliding_window;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 슬라이딩 윈도우 + 덱을 이용하여 정렬효과를 볼 수 있다.
 */
//12 3
//1 5 2 3 6 2 3 7 3 5 2 6
public class _02_SlidingWindow {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Deque<Node> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                // 새로운 값이 들어올 때 마다, 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄인다.
                int now = Integer.parseInt(st.nextToken());

                while (!deque.isEmpty() && deque.getLast().value > now) {
                    deque.removeLast();
                }

                deque.addLast(new Node(now, i));

                // 범위에서 벗어난 값은 제거한다. 여기서 범위를 계속 체크 해주기 때문에, 중간에 만난 큰 값을 지워도 상관 없다.
                // 어차피 인덱스 범위 내 값만 비교하게 된다.
                if (deque.getFirst().index <= i - l) {
                    deque.removeFirst();
                }

                bw.write(deque.getFirst().value + " ");
            }

            bw.flush();
        }

    }

    static class Node {
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
