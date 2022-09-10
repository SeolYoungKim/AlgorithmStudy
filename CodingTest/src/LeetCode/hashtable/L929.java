package LeetCode.hashtable;

import java.util.Arrays;
import java.util.HashSet;

public class L929 {
    public static void main(String[] args) {

        String[] emails = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        System.out.println(method(emails));

    }

    public static int method(String[] emails) {
        // email 주소가 주어진다.
        // {local name}@{domain}의 형태로 주어짐
        // 규칙 1) local name에 .이 있을 경우 무시한다. -> kim.sy@email.com == kimsy@email.com
        // 규칙 2) local name에 +가 있을 경우, 뒤의 문자열은 무시한다. -> kim+sy@email.com == kim@email.com
        // 규칙 3) domain은 전부 같아야 같다고 취급한다. -> kimsy@e.mail.com != kimsy@email.com

        HashSet<String> set = new HashSet<>();
        for (String email : emails) {

            // 1. @ 기준으로 split
            String[] split = email.split("@");

            System.out.println(Arrays.toString(split));
            String local = split[0];
            String domain = split[1];

            // 2. "+"의 index를 찾아서 + 전까지 substring
            int idx = local.indexOf("+");
            if (idx >= 0) {
                local = local.substring(0, idx);
            }

            // 3. "."이 있는 경우 제거
            if (local.contains(".")) {
                local = local.replace(".", "");
            }
            System.out.println("local = " + local);
            System.out.println("domain = " + domain);

            // 4. domain이랑 합쳐서 set에 저장
            set.add(local + "@" + domain);  // @ 다시 복구해야됨

        }

        // 5. set size 반환 맞을ㄲㅏ모르곘네...
        return set.size();
    }
}
