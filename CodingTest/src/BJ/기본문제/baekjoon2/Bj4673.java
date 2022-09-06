package BJ.기본문제.baekjoon2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bj4673 {
    public static void main(String[] args) {
        List<String> numbers = IntStream.range(1, 10001)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        ArrayList<String> forRemove = new ArrayList<>();

        for (String number : numbers) {
            Integer remove = Integer.parseInt(number);

            for (int i = 0; i < number.length(); i++) {
                remove += Integer.parseInt(String.valueOf(number.charAt(i)));
            }
            if (remove < 10001) forRemove.add(String.valueOf(remove));
        }

        numbers.removeAll(forRemove);

        for (String number : numbers) {
            System.out.println(number);
        }
    }
}
