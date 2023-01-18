package BJ.class_lv2;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;

public class Bj2108 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(numbers);

            bw.write(average(numbers) + "\n");
            bw.write(median(numbers) + "\n");
            bw.write(mode(numbers) + "\n");
            bw.write(range(numbers) + "\n");
        }
    }

    static long average(int[] numbers) {
        long sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        double result = (double) sum / numbers.length;
        return Math.round(result);
    }

    static int median(int[] numbers) {
        return numbers[numbers.length / 2];
    }

    static int mode(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }

        Map<Integer, Long> numberCounts = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        List<Integer> results = numberCounts.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()
                        .thenComparing(comparingByKey()))
                .limit(2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        Integer first = results.get(0);
        Integer second = results.get(1);

        return numberCounts.get(first).equals(numberCounts.get(second)) ? second : first;
    }

    static int range(int[] numbers) {
        if (numbers.length == 1) {
            return 0;
        }

        return numbers[numbers.length - 1] - numbers[0];
    }
}
