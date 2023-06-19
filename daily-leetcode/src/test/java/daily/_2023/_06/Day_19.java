package daily._2023._06;

import java.util.Arrays;

public class Day_19 {
    public int largestAltitude(int[] gain) {
        //누적합
        final int[] sum = new int[gain.length + 1];
        for (int i = 0; i < gain.length; i++) {
            sum[i + 1] = sum[i] + gain[i];
        }

        Arrays.sort(sum);
        return sum[sum.length - 1];
    }
}
