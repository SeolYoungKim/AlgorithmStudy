package LeetCode.hashtable;

import java.util.*;

// TODO: 놀라운 코드는 다시한번 더 보쇼..
public class L1331 {

    public static void main(String[] args) {
        int[] arr = {40,10,20,30};

        System.out.println(Arrays.toString(method(arr)));
    }

    public static int[] method(int[] arr) {
        int length = arr.length;

        int[] copied = Arrays.copyOf(arr, length);
        Arrays.sort(copied);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : copied) {
            map.putIfAbsent(i, map.size() + 1);
        }

        int[] result = new int[length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = map.get(i);
        }

        return result;

//        int[] A = Arrays.copyOf(arr, arr.length);
//
//        Arrays.sort(A);
//
//        HashMap<Integer, Integer> rank = new HashMap<>();
//
//        for (int x : A)
//            rank.putIfAbsent(x, rank.size() + 1);
//
//        for (int i = 0; i < arr.length; ++i)
//            A[i] = rank.get(arr[i]);
//
//        return A;
    }
}
