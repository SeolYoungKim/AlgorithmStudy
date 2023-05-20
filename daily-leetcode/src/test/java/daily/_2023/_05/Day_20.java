package daily._2023._05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class Day_20 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        final Map<String, List<Node>> graph = new HashMap<>();
        buildGraph(equations, values, graph);

        double[] answer = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            final List<String> query = queries.get(i);
            final String dividend = query.get(0);
            final String divisor = query.get(1);

            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                answer[i] = -1.0;
            } else {
                answer[i] = bfs(graph, dividend, divisor);
            }
        }

        return answer;
    }

    private void buildGraph(final List<List<String>> equations, final double[] values,
            final Map<String, List<Node>> graph) {
        for (int i = 0; i < equations.size(); i++) {
            final List<String> equation = equations.get(i);
            final String node = equation.get(0);
            final String linkedNode = equation.get(1);

            graph.computeIfAbsent(node, key -> new ArrayList<>()).add(new Node(linkedNode, values[i]));
            graph.computeIfAbsent(linkedNode, key -> new ArrayList<>()).add(new Node(node, 1 / values[i]));
        }
    }

    private double bfs(Map<String, List<Node>> graph, String start, String end) {
        final Queue<Node> queue = new LinkedList<>();
        final Set<String> visited = new HashSet<>();
        queue.offer(new Node(start, 1.0));

        while (!queue.isEmpty()) {
            final Node node = queue.poll();
            final String variable = node.variable;
            final double value = node.value;

            if (variable.equals(end)) {
                return value;
            }

            visited.add(variable);

            final List<Node> linkedNodes = graph.get(variable);
            for (Node linkedNode : linkedNodes) {
                final String linkedVariable = linkedNode.variable;
                final double linkedValue = linkedNode.value;

                if (!visited.contains(linkedVariable)) {
                    queue.offer(new Node(linkedVariable, value * linkedValue));  // 다음 값을 계산해서 넣어준다. (계산 값 누적)
                }
            }
        }

        return -1.0;  // while문을 다 돌아도 끝나는 지점이 없는경우 -1.0을 리턴.
    }

    private static class Node {
        private String variable;
        private double value;

        public Node(final String variable, final double value) {
            this.variable = variable;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "variable='" + variable + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    @Test
    void test() {
        final double[] result = calcEquation(
                List.of(
                        List.of("a", "b"), List.of("b", "c")
                ),
                new double[]{2.0, 3.0},
                List.of(
                        List.of("a", "c"),
                        List.of("b", "a"),
                        List.of("a", "e"),
                        List.of("a", "a"),
                        List.of("x", "x")
                )
        );

        System.out.println(Arrays.toString(result));
    }
}
