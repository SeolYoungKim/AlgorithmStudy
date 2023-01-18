package BJ.class_lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1654 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[] lanCables = new int[k];
            long totalLength = 0;
            for (int i = 0; i < k; i++) {
                int length = Integer.parseInt(br.readLine());
                totalLength += length;
                lanCables[i] = length;
            }

            long right = totalLength / n;
            long left = 1;
            long result = Long.MIN_VALUE;
            while (left <= right) {
                long mid = (right + left) / 2;
                int count = 0;

                for (int lanCable : lanCables) {
                    count += lanCable / mid;
                }

                if (count < n) {
                    right = mid - 1;
                } else {
                    result = Math.max(result, mid);
                    left = mid + 1;
                }
            }

            System.out.println(result);
        }
    }
}
