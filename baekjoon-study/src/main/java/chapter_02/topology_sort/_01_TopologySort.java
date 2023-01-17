package chapter_02.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2252번
 */
public class _01_TopologySort {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeNumber = Integer.parseInt(st.nextToken());
            int edgeNumber = Integer.parseInt(st.nextToken());

            int[] inDegree = new int[nodeNumber + 1];
            List<List<Integer>> nodes = new ArrayList<>();
            for (int i = 0; i <= nodeNumber; i++) {
                nodes.add(new ArrayList<>());
            }

            for (int i = 0; i < edgeNumber; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st2.nextToken());
                int nextNode = Integer.parseInt(st2.nextToken());

                nodes.get(node).add(nextNode);
                inDegree[nextNode]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= nodeNumber; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();  // 1
                bw.write(poll + " ");

                List<Integer> linkedNodes = nodes.get(poll);
                for (Integer linkedNode : linkedNodes) {  // 2, 3, 4
                    inDegree[linkedNode]--;
                    if (inDegree[linkedNode] == 0) {
                        queue.offer(linkedNode);
                    }
                }
            }

            bw.flush();
        }
    }
}
