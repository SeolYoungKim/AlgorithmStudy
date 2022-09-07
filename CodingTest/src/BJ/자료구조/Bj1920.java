package BJ.자료구조;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1920 {

    public static int[] intArrA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        intArrA = new int[N];

        for (int i = 0; i < N; i++) {
            intArrA[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(intArrA);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            if (binarySearch(Integer.parseInt(st.nextToken()))) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.println(sb);
//        bw.write(String.valueOf(sb));
//        bw.flush();
//        bw.close();
    }

    public static boolean binarySearch(int target) {

        int mid;
        int high = intArrA.length - 1;
        int low = 0;

        while (low <= high) {
            mid = (high + low) / 2;  // 이걸 잘못적었었다.. ㅠ

            if (target == intArrA[mid]) {
                return true;
            } else if (target < intArrA[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
