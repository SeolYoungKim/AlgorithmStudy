package daily._2023._05;

import java.util.HashMap;
import java.util.Map;

public class Day_31 {
    /**
     * 서로 다른 역 사이의 고객 이동 시간을 추적하여 평균 시간을 계산하는 클래스
     */
    private static class UndergroundSystem {
        private final Map<Integer, Passenger> passenger = new HashMap<>();
        private final Map<String, Route> route = new HashMap<>();

        public UndergroundSystem() {
        }

        private static class Passenger {
            private String start;
            private String end;
            private int startTime;
            private int totalTime;

            public Passenger(final String start, final int startTime) {
                this.start = start;
                this.startTime = startTime;
            }
        }

        private static class Route {
            private String start;
            private String end;
            private int totalTime;
            private int count;

            public Route(final String start, final String end, final int totalTime,
                    final int count) {
                this.start = start;
                this.end = end;
                this.totalTime = totalTime;
                this.count = count;
            }
        }

        public void checkIn(int id, String stationName, int t) {
            // card ID가 id인 고객이 t 시간에 stationName에서 체크인
            // 고객은 한 번에 한 장소에서만 체크인 가능
            if (!passenger.containsKey(id)) {
                passenger.put(id, new Passenger(stationName, t));
            }
        }

        public void checkOut(int id, String stationName, int t) {
            if (passenger.containsKey(id)) {
                // card ID가 id인 고객이 t 시간에 stationName에서 체크아웃
                final Passenger passenger = this.passenger.get(id);
                this.passenger.remove(id);
                passenger.end = stationName;
                passenger.totalTime = t - passenger.startTime;

                final String strRoute = passenger.start + "->" + passenger.end;
                if (!route.containsKey(strRoute)) {
                    route.put(strRoute,
                            new Route(passenger.start, passenger.end, passenger.totalTime, 1));
                } else {
                    final Route storedRoute = route.get(strRoute);
                    storedRoute.totalTime += passenger.totalTime;
                    storedRoute.count++;

                    route.put(strRoute, storedRoute);
                }
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            // startStation ~ endStation까지 이동하는 데 걸리는 평균 시간을 반환 (발생했던 모든 경우에 대해)
            // endStation ~ startStation 평균 != startStation ~ endStation 평균 (같거나 다를 수 있음)

            final String target = startStation + "->" + endStation;
            final Route route = this.route.get(target);
            return (double) route.totalTime / route.count;
        }
    }
}