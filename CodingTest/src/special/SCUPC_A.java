package special;

import java.io.*;

/**
 * 서울 사이버대학교 A번 문제
 */
public class SCUPC_A {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            String memo = br.readLine();
            String result = check(memo);

            System.out.println(result);
        }
    }

    static String check(String memo) {
        if (!memo.contains("security")) {
            return "bigdata?";
        }

        if (!memo.contains("bigdata")) {
            return "security!";
        }

        int idx = 0;
        int dataCounts = 0;
        int securityCounts = 0;

        while (idx < memo.length()) {
            if (memo.charAt(idx) == 'b') {
                dataCounts++;
                idx += 7;
                continue;
            }

            securityCounts++;
            idx += 8;
        }

        if (dataCounts > securityCounts) {
            return "bigdata?";
        }

        if (dataCounts < securityCounts) {
            return "security!";
        }

        return "bigdata? security!";
    }
}
