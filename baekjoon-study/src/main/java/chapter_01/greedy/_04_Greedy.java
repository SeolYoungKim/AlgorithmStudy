package chapter_01.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 1931번 "회의실 배정하기"
 */
public class _04_Greedy {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            List<Meeting> meetings = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                meetings.add(new Meeting(start, end));
            }

            Comparator<Meeting> compareByEnd = Comparator.comparingInt((Meeting m) -> m.end);
            Comparator<Meeting> compareByStart = Comparator.comparingInt((Meeting m) -> m.start);
            Comparator<Meeting> meetingComparator = compareByEnd.thenComparing(compareByStart);

            meetings.sort(meetingComparator);

//            System.out.println(meetings);

            int count = 1;
            int end = meetings.get(0).end;
            for (int i = 1; i < n; i++) {
                // end와 다음 요소의 start를 비교한다.
                Meeting next = meetings.get(i);
                int nextStart = next.start;

                if (nextStart >= end) {
                    count++;
                    end = next.end;
                }
            }

            System.out.println(count);
        }
    }

    static class Meeting {
        private final int start;
        private final int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }
}
