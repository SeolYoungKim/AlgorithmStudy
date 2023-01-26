package BJ.class_lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Bj1158 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = i + 1;
            }

            List<Integer> result = new ArrayList<>();

            int idx = k - 1;  // 첫번째 요소 제거 포인터
            while (true) {
                result.add(numbers[idx]);
                numbers = copy(numbers, idx);

                if (numbers.length == 0) {
                    break;
                }

                idx = (idx + k - 1) % numbers.length;
            }

            StringJoiner sj = new StringJoiner(", ", "<", ">");
            for (Integer num : result) {
                sj.add(num + "");
            }

            System.out.println(sj);
        }
    }

    static int[] copy(int[] arr, int delIdx) {
        int[] copied = new int[arr.length - 1];
        for (int i = 0; i < delIdx; i++) {
            copied[i] = arr[i];
        }

        for (int i = delIdx + 1; i < arr.length; i++) {
            copied[i - 1] = arr[i];
        }

        return copied;
    }
}
