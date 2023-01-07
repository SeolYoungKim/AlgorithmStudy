package BJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Bj10814 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            List<Member> members = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int age = Integer.parseInt(st.nextToken());
                String name = st.nextToken();

                members.add(new Member(age, name, i));
            }

            members.stream().sorted(Comparator.comparingInt(Member::age)
                            .thenComparingInt(Member::order))
                    .forEach(System.out::println);
        }
    }

    static class Member {
        int age;
        String name;
        int order;

        public Member(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }

        public int age() {
            return age;
        }

        public String name() {
            return name;
        }

        public int order() {
            return order;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}
