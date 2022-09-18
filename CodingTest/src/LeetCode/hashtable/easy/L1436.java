package LeetCode.hashtable.easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/destination-city/
 */
public class L1436 {
    public static void main(String[] args) {

        List<List<String>> paths = List.of(
                List.of(
                        "B", "C"
                ),
                List.of(
                        "D", "B"
                ),
                List.of(
                        "C", "A"
                )
        );

        System.out.println(method(paths));

    }

    public static String method(List<List<String>> paths) {
        // index 0번은 1번으로 이동한다.
        // index 0번을 key로 해서 value에 이동하는 목적지를 넣는다.
        // 목적지가 없는 곳이 도착지이다. or 키에 없는 게 목적지이다.

        String h = "";
        HashMap<String, String> paths_loc = new HashMap<>();

        for (List<String> cities : paths) {
            paths_loc.put(cities.get(0), cities.get(1));
        }

        for (String ret : paths_loc.values()) {
            if (!paths_loc.containsKey(ret)){
                h = ret;
            }
        }
        return h;

        // 혹은, 0번은 0번대로, 1번은 1번대로 모은다.
        // 0번 List에 1번 요소가 들어있는지 확인한다.
        // 없으면 걔가 도착지

//        ArrayList<String> start = new ArrayList<>();
//        ArrayList<String> destination = new ArrayList<>();
//
//        for (List<String> path : paths) {
//            start.add(path.get(0));
//            destination.add(path.get(1));
//        }
//
//        String result = "";
//        for (String s : destination) {
//            if (!start.contains(s)) {
//                result = s;
//            }
//        }
//
//        return result;
    }
}
