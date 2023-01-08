package chapter_02.graph;

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

public class _03_Graph {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int testNumber = Integer.parseInt(br.readLine());
            List<TestCase> testCases = new ArrayList<>();
            for (int i = 0; i < testNumber; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int nodesNumber = Integer.parseInt(st.nextToken());
                int edgeNumber = Integer.parseInt(st.nextToken());

                TestCase testCase = new TestCase();
                testCase.init(nodesNumber);

                for (int j = 0; j < edgeNumber; j++) {
                    st = new StringTokenizer(br.readLine());
                    int node = Integer.parseInt(st.nextToken());
                    int nextNode = Integer.parseInt(st.nextToken());

                    testCase.nodes.get(node).add(nextNode);
                    testCase.nodes.get(nextNode).add(node);
                }

                testCases.add(testCase);
            }

            for (TestCase testCase : testCases) {
                bfs(testCase);
            }

            for (TestCase testCase : testCases) {
                if (testCase.isBipartiteGraph()) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }

            bw.flush();
        }
    }

    enum Color {
        RED, BLUE
    }

    static class TestCase {
        List<List<Integer>> nodes = new ArrayList<>();
        Color[] colors;
        boolean[] visited;

        void init(int nodesNumber) {
            for (int i = 0; i <= nodesNumber; i++) {
                nodes.add(new ArrayList<>());
            }

            colors = new Color[nodesNumber + 1];
            visited = new boolean[nodesNumber + 1];
        }

        boolean isBipartiteGraph() {
            for (int i = 1; i < nodes.size(); i++) {
                List<Integer> linkedNodes = nodes.get(i);
                for (Integer linkedNode : linkedNodes) {
                    if (colors[i] == colors[linkedNode]) {
                        return false;
                    }
                }
            }

            return true;
        }

        @Override
        public String toString() {
            return nodes.toString();
        }
    }

    static void bfs(TestCase testCase) {
        boolean[] visited = testCase.visited;
        Color[] colors = testCase.colors;

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                colors[i] = Color.RED;

                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);

                List<List<Integer>> nodes = testCase.nodes;
                while (!queue.isEmpty()) {
                    Integer node = queue.poll();

                    List<Integer> linkedNodes = nodes.get(node);
                    for (Integer linkedNode : linkedNodes) {
                        if (!visited[linkedNode]) {
                            visited[linkedNode] = true;
                            queue.offer(linkedNode);

                            if (colors[node] == Color.RED) {
                                colors[linkedNode] = Color.BLUE;
                            } else {
                                colors[linkedNode] = Color.RED;
                            }
                        }
                    }
                }
            }
        }
    }
}
