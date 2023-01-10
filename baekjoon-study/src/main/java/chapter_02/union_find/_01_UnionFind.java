package chapter_02.union_find;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _01_UnionFind {
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int operationNumber = Integer.parseInt(st.nextToken());

            numbers = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                numbers[i] = i;
            }

            for (int i = 0; i < operationNumber; i++) {
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                if (command == 0) {
                    union(num1, num2);
                    continue;
                }

                if (find(num1) == find(num2)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }

            bw.flush();
        }
    }

    static int find(int num) {
        // 같으면 집합의 루트 노드임
        if (numbers[num] == num) {
            return num;
        }

        // 다르면 값을 인덱스로 갖는 곳으로 찾아가야 함
        // 값을 루트 노드 값으로 변경
        return numbers[num] = find(numbers[num]);
    }

    static void union(int num1, int num2) {
        // 해당 숫자의 루트 노드를 탐색
        num1 = find(num1);
        num2 = find(num2);

        if (num1 != num2) {  // 루트 노드가 다르면 집합이 다른 것임
            numbers[num2] = num1;  // 루트 노드 통합
        }
    }
}
