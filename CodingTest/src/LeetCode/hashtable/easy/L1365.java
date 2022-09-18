package LeetCode.hashtable.easy;

/**
 * How Many Numbers Are Smaller Than the Current Number
 */
public class L1365 {
    public static void main(String[] args) {
        int[] nums = {7,7,7,7};
        int[] method = method(nums);

        for (int i : method) {
            System.out.println("i = " + i);
        }
    }

    public static int[] method(int[] nums) {
        int[] results = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int curNum = nums[i];

            for (int num : nums) {
                if (curNum > num) {
                    count++;
                }
            }
            results[i] = count;
        }

        return results;
    }
}
