package chapter_02.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1976번 "여행 가자"
 */
public class _02_UnionFind {
    static int[] cities;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int cityNumber = Integer.parseInt(br.readLine());
            int travelCityNumber = Integer.parseInt(br.readLine());

            cities = new int[cityNumber + 1];
            for (int i = 1; i <= cityNumber; i++) {
                cities[i] = i;
            }

            for (int i = 1; i <= cityNumber; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= cityNumber; j++) {
                    int zeroOrOne = Integer.parseInt(st.nextToken());
                    if (zeroOrOne == 1) {
                        union(i, j);
                    }
                }
            }

            int prevRoot = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < travelCityNumber; i++) {
                int travelCity = Integer.parseInt(st.nextToken());
                if (prevRoot == Integer.MIN_VALUE) {
                    prevRoot = find(travelCity);
                    continue;
                }

                // 이전 루트와 비교
                int currRoot = find(travelCity);
                if (prevRoot != currRoot) {
                    System.out.println("NO");
                    return;
                }
            }

            System.out.println("YES");
        }
    }

    static int find(int num) {
        if (cities[num] == num) {
            return num;
        }

        return cities[num] = find(cities[num]);
    }

    static void union(int num1, int num2) {
        num1 = find(num1);  // 루트 찾음
        num2 = find(num2);  // 루트 찾음

        if (num1 != num2) {
            cities[num2] = num1;
        }
    }
}
