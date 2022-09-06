package BJ.bruteForceSearch;
import java.util.*;

import static java.lang.Math.*;

public class ContinuousSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int result = 0;

        //TODO : 시간초과 이슈 있음. 해결하자.
        for (int i = 0; i < n - 1; i++) {
            int post = i + 1;
            int sum = a[i] + a[post];

            while (post != n - 1) {
                post += 1;
                sum += a[post];
                result = max(result, sum);
            }
        }


        System.out.println("result = " + result);


    }
}
