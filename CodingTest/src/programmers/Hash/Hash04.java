package programmers.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hash04 {

    public static void main(String[] args) {
        String[][] strArr = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Hash04 hash04 = new Hash04();
        hash04.solution(strArr);
    }
    public int solution(String[][] clothes) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String val = clothe[0];
            String key = clothe[1];

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(val);
        }

        System.out.println(map);
        return 0;
    }
}
