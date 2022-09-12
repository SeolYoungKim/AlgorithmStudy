package LeetCode.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class L448 {
    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(method(nums));
    }

    public static List<Integer> method(int[] nums) {
        List<Integer> target = IntStream.range(1, nums.length + 1)
                .boxed()
                .collect(Collectors.toList());

        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : nums) {
            set.add(num);
        }

        for (Integer integer : target) {
            if (!set.contains(integer)) {
                result.add(integer);
            }
        }

        return result;
    }
}
