import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Hash1 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();

        for (String player : participant)
            hm.put(player, hm.getOrDefault(player, 0) + 1);

        for (String player : completion)
            hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }

    @Test
    void dd() {
        //given
        String[] participant = new String[] {"1", "2", "3"};
        String[] completion = new String[] {"2", "3"};

        //when
        String solution = solution(participant, completion);

        //then
        System.out.println("solution = " + solution);
    }
}
