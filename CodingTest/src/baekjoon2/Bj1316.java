package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Bj1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<String> strArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            strArr.add(br.readLine());
        }

        int count = 0;

        for (String s : strArr) {
            ArrayList<Character> chrArr = new ArrayList<>();
            HashMap<Character, ArrayList<Integer>> chrMap = new HashMap<>();

            // 단어를 이루는 각 문자마다의 인덱스 정보를 저장한다.
            for (int i = 0; i < s.length(); i++) {
                if (!chrMap.containsKey(s.charAt(i))) {
                    chrMap.put(s.charAt(i), new ArrayList<>());
                    chrMap.get(s.charAt(i)).add(i);
                } else {
                    chrMap.get(s.charAt(i)).add(i);
                }
            }

            // index 값이 1을 초과하여 차이가 날 경우 폐기한다.
            boolean flag = true;
            outer:
            for (Character character : chrMap.keySet()) {  // 해당 루프문을 완벽히 전부 돌아야만 그룹 단어로 인정한다. 단어 당 저장된 인덱스의 차이가 1을 초과해서는 안된다.
                ArrayList<Integer> integers = chrMap.get(character);
                for (int j = 0; j < integers.size() - 1; j++) {
                    if (Math.abs(integers.get(j) - integers.get(j + 1)) > 1) {
                        flag = false; // 1을 초과하는게 하나라도 있을 경우, flag를 false로 설정하고
                        break outer;        // for 루프를 빠져나간다.
                    }
                }
            }

            if (flag) {
                count++;
            }
        }

        System.out.println(count);
    }
}
