package programmers.Hash;

import java.util.*;

public class Hash01 {

    public static void main(String[] args) {
        Hash01 hash01 = new Hash01();
        String[] str1 = {"mislav", "stanko", "mislav", "ana"};
        String[] str2 = {"stanko", "ana", "mislav"};
        String solution = hash01.solution(str1, str2);
        System.out.println(solution);
    }

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.stream(participant)
                .forEach(part -> map.put(part, map.getOrDefault(part, 0) + 1));

        for (String com : completion) {
            if (map.containsKey(com)) {
                map.put(com, map.get(com) - 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }

        return "";
    }
}
