package chapter_02.topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1516번
 */
public class _02_TopologySortBestPractice {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            List<List<Integer>> nodes = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                nodes.add(new ArrayList<>());
            }

            int[] inDegree = new int[n + 1];
            int[] selfBuild = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                selfBuild[i] = Integer.parseInt(st.nextToken());
                while (true) {
                    int preTemp = Integer.parseInt(st.nextToken());
                    if (preTemp == -1) {
                        break;
                    }

                    nodes.get(preTemp).add(i);
                    inDegree[i]++;
                }
            }

            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            int[] result = new int[n + 1];
            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (Integer next : nodes.get(now)) {
                    inDegree[next]--;

                    // 시간 업데이트
                    result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                System.out.println(result[i] + selfBuild[i]);
            }
        }
    }
}

//5
//10 -1
//20 1 -1
//30 2 -1
//40 3 5 -1
//100 -1
