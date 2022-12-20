package chapter_01.search.binary;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 2, 4, 5, 6, 7, 8, 9, 10};
        int value = 3;

        boolean result = binarySearch(numbers, value);
        System.out.println(result);
    }

    static boolean binarySearch(int[] numbers, int value) {
        int leftIdx = 0;
        int rightIdx = numbers.length - 1;
        int midIdx;

        while (leftIdx <= rightIdx) {
            midIdx = (leftIdx + rightIdx) / 2;
            if (value == numbers[midIdx]) {
                return true;
            }

            if (value < numbers[midIdx]) {
                rightIdx = midIdx - 1;
            }

            if (value > numbers[midIdx]) {
                leftIdx = midIdx + 1;
            }
        }

        return false;
    }
}
