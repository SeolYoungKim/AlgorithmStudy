package chapter_02.bellman_ford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class _02_BellmanFord {
    private static final int INF = Integer.MIN_VALUE;
    private static int startCity;
    private static int endCity;
    private static final List<Edge> EDGES = new ArrayList<>();
    private static int[] moneyToEarn;
    private static long[] maxMoney;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int nodeCount = Integer.parseInt(st.nextToken());
            startCity = Integer.parseInt(st.nextToken());
            endCity = Integer.parseInt(st.nextToken());
            final int edgeCount = Integer.parseInt(st.nextToken());

            for (int i = 0; i < edgeCount; i++) {
                final StringTokenizer input = new StringTokenizer(br.readLine());
                final int node = Integer.parseInt(input.nextToken());
                final int nextNode = Integer.parseInt(input.nextToken());
                final int fee = Integer.parseInt(input.nextToken());

                EDGES.add(new Edge(node, nextNode, fee));
            }

            final StringTokenizer input = new StringTokenizer(br.readLine());
            moneyToEarn = new int[nodeCount];
            for (int i = 0; i < nodeCount; i++) {
                moneyToEarn[i] = Integer.parseInt(input.nextToken());
            }

            maxMoney = new long[nodeCount];
            Arrays.fill(maxMoney, INF);

            bellmanFord(nodeCount, edgeCount);
//            System.out.println(Arrays.toString(maxMoney));
//            System.out.println(edgeToEndCity);
            // 도시에 도착하는 것이 불가능한 경우
            // 경로가 없는 경우
            if (maxMoney[endCity] == INF) {
                System.out.println("gg");
                return;
            }

            // 돈을 무한히 많이 가지고 있을 수 있는 경우
            // 사이클이 있고, 도착 도시들에서 버는 돈의 합 > 교통비 합인 경우
            if (hasCycle(edgeCount)) {
                System.out.println("Gee");
                return;
            }

            System.out.println(maxMoney[endCity]);
        }
    }

    // endCity로 갈 수 있는 노드
    // from -> to
    // n -> endCity
    // m -> n
    // k -> m
    static final Set<Integer> edgeToEndCity = new HashSet<>();

    private static void bellmanFord(int nodeCount, int edgeCount) {
        maxMoney[startCity] = moneyToEarn[startCity];

        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < edgeCount; j++) {
                final Edge edge = EDGES.get(j);
                if (edge.to == endCity) {
                    edgeToEndCity.add(edge.from);
                } else if (edgeToEndCity.contains(edge.to)) {
                    edgeToEndCity.add(edge.from);
                }

                final int arrivalMoney = moneyToEarn[edge.to];// 도시에 도착했을 때 버는 돈

                // 도시에 도착 했을 때의 돈 = 지금 가진 돈 - 교통비 + 도착 도시에서 버는 돈
                final long earnedMoney = maxMoney[edge.from] - edge.fee + arrivalMoney;
                if (maxMoney[edge.from] != INF && maxMoney[edge.to] < earnedMoney) {  // 버는 돈이 이전에 벌어놨던 것보다 큰 경우 갱신
                    maxMoney[edge.to] = earnedMoney;
                }
            }
        }
    }

    private static boolean hasCycle(int edgeCount) {
        for (int i = 0; i < edgeCount; i++) {
            final Edge edge = EDGES.get(i);
            final int arrivalMoney = moneyToEarn[edge.to];// 도시에 도착했을 때 버는 돈

            // 도시에 도착 했을 때의 돈 = 지금 가진 돈 - 교통비 + 도착 도시에서 버는 돈
            final long earnedMoney = maxMoney[edge.from] - edge.fee + arrivalMoney;
            if (maxMoney[edge.from] != INF && maxMoney[edge.to] < earnedMoney) {  // 버는 돈이 이전에 벌어놨던 것보다 큰 경우 갱신
                // 여기서, 순환이 발생한 경우 from, to 둘중 하나에서 도착 도시로 갈 수 있는지 여부를 판단할 수 있어야 함
                if (edgeToEndCity.contains(edge.to /*엣지의 도착 노드가 edgeToEndCity에 포함되어 있어야 의미있는 사이클임*/)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static class Edge {
        private final int from;
        private final int to;
        private final int fee;

        public Edge(final int from, final int to, final int fee) {
            this.from = from;
            this.to = to;
            this.fee = fee;
        }
    }
}
