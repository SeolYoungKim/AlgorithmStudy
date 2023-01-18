package BJ.class_lv1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Bj1181 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());

            Set<String> strings = new HashSet<>();
            for (int i = 0; i < n; i++) {
                strings.add(br.readLine());
            }

            List<String> results = strings.stream()
                    .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                    .collect(Collectors.toList());

            for (String result : results) {
                bw.write(result + "\n");
            }

            bw.flush();
        }
    }
}
