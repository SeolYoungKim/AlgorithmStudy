package ThisIsCodingTest.implementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 시각(time) 문제
 */
public class Impl2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println("실행 전" + LocalDateTime.now());
        ArrayList<String> timeList = new ArrayList<>();

        // 1~60까지의 숫자로 이루어진 리스트
        List<String> strList = IntStream.range(1, 61)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        for (int i = 0; i <= N; i++) {
            for (String min : strList) {
                for (String sec : strList) {
                    timeList.add(i + "시 " + min + "분 " + sec + "초");
                    // 여기서 카운트를 그냥 증가시켜도 됨.
                }
            }
        }

        long count = timeList.stream()
                .filter(s -> s.contains("3"))
                .count();

        System.out.println("실행 후" + LocalDateTime.now());

        System.out.println("count = " + count);


    }
}
