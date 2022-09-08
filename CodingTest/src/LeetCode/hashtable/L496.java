package LeetCode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class L496 {
    public static void main(String[] args) {
        int[] nums1 = {1,3,5,2,4};
        int[] nums2 = {6,5,4,3,2,1,7};
        System.out.println(Arrays.toString(method(nums1, nums2)));
    }

    public static int[] method(int[] nums1, int[] nums2) {
        // nums1 숫자에 대해, nums2의 index를 얻는다.
        // nums2에서 index + 1을 조사한다.
        // 크면 nums1 숫자를 그 수로 치환.
        // 작으면 nums1 숫자를 -1로 치환

//        int[] results = new int[nums1.length];
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                if (nums1[i] == nums2[j]) {
//                    map.put(i, j);
//                }
//            }
//        }
//        // 아예 바로 옆이 아니구나 ㅎㅎ;;;
//        // map k-v : i=j (nums1 index, nums2 index)
//        for (Integer key : map.keySet()) {
//            // nums2의 index
//            Integer index = map.get(key);
//
//            if (index == nums2.length - 1) {
//                results[key] = -1;
//            } else {
//                boolean flag = false;
//                int bigger = 0;
//                // nums2의 index 기준으로 오른쪽을 모두 써치
//                for (int i = index + 1; i < nums2.length; i++) {
//                    if (nums1[key] < nums2[i]) {
//                        flag = true;
//                        bigger = nums2[i];
//                        break;
//                    }
//                }
//
//                if (flag) {
//                    results[key] = bigger;
//                } else {
//                    results[key] = -1;
//                }
//
//            }
//        }
//
//        return results;

        // 와 이거 개천재네......
        HashMap<Integer,Integer> hs = new HashMap();
        Stack<Integer> stack = new Stack();

        for(Integer num : nums2){
            while(!stack.isEmpty() && stack.peek() < num){
                hs.put(stack.pop(), num); // 스택에서 뽑으면서 비교하고 뽑은 값을 key, 큰 값을 value로 저장
            }
            stack.push(num);
        }

        for(int i=0;i<nums1.length;i++){
            nums1[i] = hs.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
}
