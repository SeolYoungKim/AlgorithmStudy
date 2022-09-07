package LeetCode.hashtable;

import java.util.ArrayList;

public class L2367 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9};
        int method = method(nums, 2);

        System.out.println("method = " + method);
    }

    public static int method(int[] nums, int diff) {
        // diff 만큼 차이나는 (x, y, z)의 갯수를 세어라. (중복 ㄴㄴ)
        // x - y == diff
        // y - z == diff
        // x - y == y - z
        // x - 2y + z == 0  || x + z == 2y 인 쌍을 찾아라?

        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length - 2; i++) {
            for (int j = 1; j < length - 1; j++) {
                for (int k = 2; k < length; k++) {
                    if (i < j && j < k && nums[j] - nums[i] == diff) {
                        if (nums[i] - (2 * nums[j]) + nums[k] == 0) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
