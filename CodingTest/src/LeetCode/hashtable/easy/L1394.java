package LeetCode.hashtable.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class L1394 {
    public static void main(String[] args) {
        int[] arr = {2,2,2,3,3};
        System.out.println(method(arr));
    }

    public static int method(int[] arr) {
        // 숫자 값 == 숫자 출현 빈도 -> lucky num
        // 가장 큰 행운의 정수를 반환. 없으면 -1
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        ArrayList<Integer> intArr = new ArrayList<>();
        for (Integer key : map.keySet()) {

            if (key.equals(map.get(key))) {
                intArr.add(key);
            }
        }

        if (intArr.size() == 0) {
            return -1;
        }

        intArr.sort(Collections.reverseOrder());
        return intArr.get(0);
    }
}
