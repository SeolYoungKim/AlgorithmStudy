package BJ.bruteForceSearch;

import java.util.*;

/**
 * 분해합
 */

public class Bj2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int constructor = 0;

        for (int i = 0; i < num; i++) {
            String stringNum = String.valueOf(i);
            int sum = 0;

            for (int j = 0; j < stringNum.length(); j++) {
                String substring = stringNum.substring(j, j + 1);
                sum += Integer.parseInt(substring);
            }

            if (i + sum == num) {
                constructor = i;
                break;
            }
        }


        // 너무 어렵게 생각했다 ㅎㅎ;
//        String num = sc.next();
//        int constructor = 0;
//
//        int length = num.length();
//        int sub = length * 9;
//
//        int lastNum = Integer.parseInt(num);
//        int startNum = lastNum - sub;
//
//        if (startNum > 0) {
//            for (int i = startNum; i < lastNum; i++) {
//                String stringNum = String.valueOf(i);
//                int sum = 0;
//
//                for (int j = 0; j < stringNum.length(); j++) {
//
//                    String substring = stringNum.substring(j, j + 1);
//                    sum += Integer.parseInt(substring);
//
//                }
//
//                if (sum + i == lastNum) {
//                    constructor = i;
//                    break;
//                }
//            }
//        }

        System.out.println("constructor = " + constructor);
    }
}
