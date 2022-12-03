package chapter_01.data_structure._03_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _01_SlidingWindow {

    static int[] password;
    static int[] myArr;
    static int checkCount;  // A C G T 각각 개수 조건을 만족할 경우 +1을 한다. 총 4가 되면 해당 문자열은 조건을 만족하는 문자열이 된다.

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            char[] sequences = br.readLine().toCharArray();

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            password = new int[4];
            for (int i = 0; i < 4; i++) {
                password[i] = Integer.parseInt(st2.nextToken());

                if (password[i] == 0) {  // password로 입력한 것 중, 갯수가 0인 것은 미리 checkCount에 넣자. (0개라면, 새로운 것을 입력받아도 0개 이상이므로, 무조건 만족하기 때문)
                    checkCount++;
                }
            }

            myArr = new int[4];
            int result = 0;

            // 0부터 p-1까지 확인한다. (첫번째 케이스 확인)
            for (int i = 0; i < p; i++) {
                add(sequences[i]);
            }

            if (checkCount == 4) {
                result++;
            }

            // 맨 앞자리에서 한개를 빼고, 맨 뒷자리에 한개를 더한다. -> 반복
            for (int i = p; i < s; i++) {
                int j = i - p;

                add(sequences[i]);
                remove(sequences[j]);

                if (checkCount == 4) {
                    result++;
                }
            }

            System.out.println(result);
        }

    }

    public static void add(char seq) {
        switch (seq) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == password[0]) {
                    checkCount++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == password[1]) {
                    checkCount++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == password[2]) {
                    checkCount++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == password[3]) {
                    checkCount++;
                }
                break;
        }
    }

    public static void remove(char seq) {
        switch (seq) {
            case 'A':
                if (myArr[0] == password[0]) {  // 서로 같으면, 이미 이전에 체크가 되었으므로, 중복 체크를 방지하기 위해 checkCount 1 감소
                    checkCount--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == password[1]) {
                    checkCount--;
                }
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == password[2]) {
                    checkCount--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == password[3]) {
                    checkCount--;
                }
                myArr[3]--;
                break;
        }
    }
}
