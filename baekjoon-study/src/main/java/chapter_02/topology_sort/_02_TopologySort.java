package chapter_02.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * 백준 1516번
 */
public class _02_TopologySort {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());

            List<List<Integer>> nodes = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                nodes.add(new ArrayList<>());
            }

            int[] timesOfBuilding = new int[n + 1];
            int[] inDegree = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                String[] inputs = br.readLine().split(" ");
                timesOfBuilding[i] = Integer.parseInt(inputs[0]);  // 시간 저장

                for (int j = 1; j < inputs.length; j++) {
                    if (inputs[j].equals("-1")) {
                        break;
                    }

                    nodes.get(Integer.parseInt(inputs[j])).add(i);
                    inDegree[i]++;
                }
            }

            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }

            int[] results = Arrays.copyOf(timesOfBuilding, n + 1);
            while (!queue.isEmpty()) {
                Integer node = queue.poll();

                List<Integer> linkedNodes = nodes.get(node);
                for (Integer linkedNode : linkedNodes) {
                    // 여기서, 이전 노드의 정보를 방문하는 노드에 저장해야 함. (루트 저장)
                    // 동시에 지어지는 경우도 고려해야.. ㅅㅂ
                    if (!visited[linkedNode]) {
                        // 방문하지 않은 경우에는 그냥 이전 노드의 시간값을 더해 저장함
                        results[linkedNode] = timesOfBuilding[linkedNode] + results[node];
                    } else {
                        // 방문한 경우에는 (저장된 자기 자신의 시간값)과 (이전 노드 + 자기 자신의 시간값)과 비교해 저장함
                        results[linkedNode] = Math.max(results[linkedNode],
                                results[node] + timesOfBuilding[linkedNode]);
                    }

                    visited[linkedNode] = true;

                    inDegree[linkedNode]--;
                    if (inDegree[linkedNode] == 0) {
                        queue.offer(linkedNode);
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                bw.write(results[i] + "\n");
            }

            bw.flush();
        }
    }
}

//5
//10 -1
//20 1 -1
//30 2 -1
//40 3 5 -1
//100 -1
