package daily._2023._05;

import java.util.HashMap;
import java.util.Map;

public class Day_31 {
    /**
     * 서로 다른 역 사이의 고객 이동 시간을 추적하여 평균 시간을 계산하는 클래스
     */
    private static class UndergroundSystem {
        private final Map<Integer, Route> customersRoute = new HashMap<>();

        public UndergroundSystem() {
        }

        private static class Route {
            private String start;
            private String end;
            private int startTime;
            private int totalTime;

            public Route(final String start, final int startTime) {
                this.start = start;
                this.startTime = startTime;
            }
        }

        public void checkIn(int id, String stationName, int t) {
            // card ID가 id인 고객이 t 시간에 stationName에서 체크인
            // 고객은 한 번에 한 장소에서만 체크인 가능
            customersRoute.put(id, new Route(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            // card ID가 id인 고객이 t 시간에 stationName에서 체크아웃
            final Route route = customersRoute.get(id);
            route.end = stationName;
            route.totalTime = t - route.startTime;
        }

        public double getAverageTime(String startStation, String endStation) {
            // startStation ~ endStation까지 이동하는 데 걸리는 평균 시간을 반환 (발생했던 모든 경우에 대해)
            // endStation ~ startStation 평균 != startStation ~ endStation 평균 (같거나 다를 수 있음)

            return customersRoute.values().stream()
                    .filter(route -> startStation.equals(route.start)
                            && endStation.equals(route.end))
                    .mapToInt(route -> route.totalTime)
                    .average()
                    .orElse(0);
        }
    }
}