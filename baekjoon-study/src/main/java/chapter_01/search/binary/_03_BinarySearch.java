package chapter_01.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1300번 "배열에서 K번째 수 찾기"
 */
public class _03_BinarySearch {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            int temp = k;
            int x = 0;
            while (temp >= 0) {
                temp -= n;
                x++;
            }

//            System.out.println(x);

            int first = n * n - (n - x + 1) * n;  // 블럭마다 첫번째 인덱스
//            System.out.println(first);

            int y = k - first + 1;
//            System.out.println(y);

            System.out.println(x * y);
//            System.out.println(arrayB);
//            System.out.println(arrayB.get(k));
        }
    }
}
