package chapter_01.sort._02_select_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 백준 1427번 "내림차순으로 자릿수 정렬하기"
 */
public class _01_SelectSort {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String numberStr = br.readLine();
            List<Integer> list = IntStream.range(0, numberStr.length())
                    .mapToObj(i -> Integer.valueOf(numberStr.substring(i, i + 1)))
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

            for (Integer integer : list) {
                bw.write(integer + "");
            }
            bw.flush();
        }
    }
}
