package BJ.bruteForceSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prac {

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] MH = new String[N]; //민혁이가 질문한 세 자리 수
        int[][] MH_info = new int[N][2]; //민혁이가 질문한 세 자리수에대한 정보 [0]:스트라이크 [1]:볼
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            MH[i] = st.nextToken();
            MH_info[i][0] = Integer.parseInt(st.nextToken());
            MH_info[i][1] = Integer.parseInt(st.nextToken());
        }

        // 2. 연산 브루트포스
        int ans = 0;
        for (int i = 1; i <= 9; i++) { // 첫째자리
            for (int j = 1; j <= 9; j++) { // 둘째자리
                if(i!=j) {
                    for (int k = 1; k <= 9; k++) { // 셋째자리
                        if(k!=i&&k!=j) {
                            boolean flag = true;
                            for (int s = 0; s < N; s++) { // 민혁이가 질문한 수
                                int strike = 0;
                                int ball = 0;
                                String str = MH[s];
                                if(str.charAt(0)-'0'==i) strike++;
                                if(str.charAt(1)-'0'==j) strike++;
                                if(str.charAt(2)-'0'==k) strike++;
                                if(str.charAt(0)-'0'==j||str.charAt(0)-'0'==k) ball++;
                                if(str.charAt(1)-'0'==i||str.charAt(1)-'0'==k) ball++;
                                if(str.charAt(2)-'0'==i||str.charAt(2)-'0'==j) ball++;
                                if(MH_info[s][0]!=strike||MH_info[s][1]!=ball) {
                                    flag = false;
                                    break;
                                }
                            }
                            if(flag) ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

}