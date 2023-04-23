package daily._2023._04;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Day_01 {
    public int search(int[] nums, int target) {
//        return binarySearch(nums, 0, nums.length - 1, target);
        return binarySearchWhile(nums, target);
    }

    public int binarySearchWhile(int[] numbers, int value) {
        int leftIdx = 0;
        int rightIdx = numbers.length - 1;
        int midIdx;

        while (leftIdx <= rightIdx) {
            midIdx = (leftIdx + rightIdx) / 2;
            if (value == numbers[midIdx]) {
                return midIdx;
            }

            if (value < numbers[midIdx]) {
                rightIdx = midIdx - 1;
            }

            if (value > numbers[midIdx]) {
                leftIdx = midIdx + 1;
            }
        }

        return -1;
    }

    public int binarySearch(int[] nums, int startIdx, int endIdx, int target) {
        if (startIdx >= endIdx) {
            if (nums[startIdx] == target) {
                return startIdx;
            }
            return -1;
        }

        final int centerIdx = (startIdx + endIdx) / 2;
        final int centerVal = nums[centerIdx];

        if (centerVal < target) {
            return binarySearch(nums, centerIdx + 1, endIdx, target);
        }

        if (centerVal > target) {
            return binarySearch(nums, startIdx, centerIdx - 1, target);
        }

        return centerIdx;
    }

    @Test
    void test() {
        final int result0 = search(new int[]{2, 5}, 5);
        assertThat(result0).isEqualTo(1);

        final int result1 = search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        assertThat(result1).isEqualTo(4);

        final int result2 = search(new int[]{-1, 0, 3, 5, 9, 12}, 2);
        assertThat(result2).isEqualTo(-1);
    }
}
