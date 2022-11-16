package programmers.Hash;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Hash03 {

    public static void main(String[] args) {
        Hash03 hash03 = new Hash03();
        String[] strArr = {"12", "123", "1235", "567", "88"};
        boolean solution = hash03.solution(strArr);

        System.out.println(solution);
    }
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : phone_book) {
            map.put(s, 0);
        }

        for (String phoneNum : phone_book) {
            for (int i = 1; i < phoneNum.length(); i++) {
                if (map.containsKey(phoneNum.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }

    private static class PhoneNumber {
        private final String number;

        public PhoneNumber(String number) {
            this.number = number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PhoneNumber that = (PhoneNumber) o;
            return number.startsWith(that.number) || that.number.startsWith(number);
        }

        @Override
        public int hashCode() {
            return Objects.hash(1);
        }

        @Override
        public String toString() {
            return "PhoneNumber{" +
                    "number='" + number + '\'' +
                    '}';
        }
    }
}
