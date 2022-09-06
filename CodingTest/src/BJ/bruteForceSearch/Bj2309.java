package BJ.bruteForceSearch;

import java.util.*;

/**
 * 일곱난쟁이
 */
public class Bj2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> result = new ArrayList<>();
        int[] height = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            height[i] = sc.nextInt();
            result.add(height[i]);
            sum += height[i];
        }

        sum -= 100;  // sum 에서 100을 빼면 나머지 두마리의 합.

        outerLoop:
        for (int i = 0; i < 9; i++) {  // IndexOutOfBounds 유발 요인.
            for (int j = i + 1; j < 9; j++) {

                int temp = height[i] + height[j];

                if (temp == sum) {
                    result.remove(j);
                    result.remove(i);
                    break outerLoop;  // break 를 내부 for 문만 해주면 안된다.
                }
            }
        }

        Collections.sort(result);

        for (Integer integer : result) {
            System.out.println(integer);
        }

    }
}