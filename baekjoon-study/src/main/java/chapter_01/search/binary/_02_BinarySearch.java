package chapter_01.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2343번 "블루레이 만들기"
 */
public class _02_BinarySearch {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] lessons = new int[n];
            int start = 0;
            int end = 0;
            for (int i = 0; i < n; i++) {
                lessons[i] = Integer.parseInt(st.nextToken());
                if (start < lessons[i]) {
                    start = lessons[i];
                }
                end += lessons[i];
            }

            while (start <= end) {
                int mid = (start + end) / 2;
                int sum = 0;
                int count = 0;

                for (int i = 0; i < n; i++) {  // mid 값으로 모든 레슨을 저장할 수 있는지 확인
                    if (sum + lessons[i] > mid) {  // 계속 더하다가 mid 값을 넘어가는 index에서 카운트 증가
                        count++;
                        sum = 0;  // 초기화
                    }

                    sum += lessons[i];  // mid 값을 넘어가는 인덱스는 시작값이 된다.
                }

                if (sum != 0) {  // sum이 0이 아닐 경우, 레슨이 남아있는 경우이므로 블루레이가 1개 더 필요함
                    count++;
                }

                if (count > m) {  // 블루레이가 정해진 개수가 넘어가는 경우 블루레이 사이즈를 증가시켜야 한다
                    start = mid + 1;
                } else {
                    end = mid - 1;  // 블루레이가 정해진 개수가 넘어가지 않으면 블루레이 크기를 줄여가면서 최소 크기를 구한다.
                }
            }

            System.out.println(start);
        }
    }
}
