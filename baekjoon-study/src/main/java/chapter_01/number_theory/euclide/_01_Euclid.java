package chapter_01.number_theory.euclide;

import java.io.IOException;

public class _01_Euclid {
    public static void main(String[] args) throws IOException {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
//            int t = Integer.parseInt(br.readLine());
//
//
//            for (int i = 0; i < t; i++) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                int num1 = Integer.parseInt(st.nextToken());
//                int num2 = Integer.parseInt(st.nextToken());
//
//                int gcd = gcd(num1, num2);
//                int lcm = num1 * num2 / gcd;
//                bw.write(lcm + "\n");
//            }
//
//            bw.flush();
//        }

        int i = gcd(11111, 111);
        int j = gcdRecursion(11111, 111);
        System.out.println("i = " + i);
        System.out.println("j = " + j);
    }

    static int gcdRecursion(int more, int less) {
        if (less == 0) {
            return more;
        }

        return gcdRecursion(less, more % less);
    }

    static int gcd(int num1, int num2) {
        int more;
        int less;
        if (num1 > num2) {
            more = num1;
            less = num2;
        } else {
            more = num2;
            less = num1;
        }

        int remain = more % less;
        if (remain == 0) {
            return less;
        }

        while (true) {
            more = less;
            less = remain;

            remain = more % less;
            if (remain == 0) {
                return less;
            }
        }
    }
}
