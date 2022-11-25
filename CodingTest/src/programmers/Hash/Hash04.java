package programmers.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hash04 {

    public static void main(String[] args) {
        String[][] strArr = {
                {"yellow_hat", "headgear"},
                {"green_turban", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"glasses", "face"},
                {"face_paint", "face"},
                {"green_pants", "pants"},
                {"blue_pants", "pants"},
                {"t_shirts", "shirts"},
                {"v_shirts", "shirts"},
                {"duck_down", "jumper"},
                {"blue_jacket", "jumper"}
        };

        Hash04 hash04 = new Hash04();
        int solution = hash04.solution(strArr);
        System.out.println("solution = " + solution);
    }

    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 1) + 1);  // 경우의 수를 저장. n + 1
        }

        System.out.println(map);

        int sum = map.values().stream()
                .mapToInt(value -> value)
                .reduce(1, (a, b) -> a * b);

        return sum - 1;
    }
}
