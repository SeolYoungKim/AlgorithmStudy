package LeetCode.hashtable.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class L1122 {
    public static void main(String[] args) {
        int[] arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31}, arr2 = {2,42,38,0,43,21};

        System.out.println(Arrays.toString(method(arr1, arr2)));
    }

    public static int[] method(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);

        ArrayList<Integer> inArr2 = new ArrayList<>();
        ArrayList<Integer> notInArr2 = new ArrayList<>();

        for (int num1 : arr1) {
            if (Arrays.stream(arr2).noneMatch(i -> i == num1)) {
                notInArr2.add(num1);
            }
        }

        for (int num2 : arr2) {
            for (int num1 : arr1) {
                if (num2 == num1) {
                    inArr2.add(num1);
                }
            }
        }

        inArr2.addAll(notInArr2);

        for (int i = 0; i < inArr2.size(); i++) {
            arr1[i] = inArr2.get(i);
        }

        return arr1;

        // 이렇게도 푼다
//        int[] cnt = new int[1001];
//        for(int n : arr1) cnt[n]++;
//        int i = 0;
//        for(int n : arr2) {
//            while(cnt[n]-- > 0) {
//                arr1[i++] = n;
//            }
//        }
//        for(int n = 0; n < cnt.length; n++) {
//            while(cnt[n]-- > 0) {
//                arr1[i++] = n;
//            }
//        }
//        return arr1;

    }
}
