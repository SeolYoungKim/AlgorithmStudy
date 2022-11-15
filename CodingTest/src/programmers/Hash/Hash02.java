package programmers.Hash;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Hash02 {

    public int solution(int[] nums) {
        int count = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int size = set.size();
        if (size == count || count < size) {
            return count;
        }

        return size;
    }
}
