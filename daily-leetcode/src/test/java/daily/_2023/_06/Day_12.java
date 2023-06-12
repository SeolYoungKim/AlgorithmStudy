package daily._2023._06;

import java.util.ArrayList;
import java.util.List;

public class Day_12 {
    public List<String> summaryRanges(int[] nums) {
        // 연속된 경우 a->b
        // 연속되지 않은 경우 a

        List<String> results = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;  // 숫자가 연속되지 않을 때 까지 i를 증가시킨다.
            }

            if (start != nums[i]) {  // start와 현재의 nums[i]가 다르면 숫자가 연속되는 케이스다
                results.add(start + "->" + nums[i]);   // 연속되는 숫자임을 표현
            } else {  // 그렇지 않으면, 숫자가 연속되지 않는 케이스다
                results.add(String.valueOf(start));  // 그냥 자기자신의 숫자를 list에 넣음
            }
        }
        return results;
    }
}
