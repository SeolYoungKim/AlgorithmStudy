package chapter_01.sort._06_radix_sort;

public class _01_RadixSortVer2 {
    public static void main(String[] args) {
        int[] numbers = {215, 15, 344, 372, 294, 100, 8, 145, 24, 198, 831};
        radixSort(numbers, 5);
    }

    static void radixSort(int[] numbers, int maxSize) {
        int[] output = new int[numbers.length];
        int jarisu = 1;
        int count = 0;

        while (count != maxSize) {
            int[] bucket = new int[10];

            for (int number : numbers) {
                bucket[(number / jarisu) % 10]++;
            }

            for (int i = 1; i < 10; i++) {  // bucket의 누적합을 구한다? 왜 ?
                bucket[i] += bucket[i - 1];
            }

            for (int i = numbers.length - 1; i >= 0; i--) {
                output[bucket[(numbers[i] / jarisu) % 10] - 1] = numbers[i];
                bucket[(numbers[i] / jarisu) % 10]--;
            }

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = output[i];
            }

            jarisu *= 10;
            count++;
        }
    }
}
