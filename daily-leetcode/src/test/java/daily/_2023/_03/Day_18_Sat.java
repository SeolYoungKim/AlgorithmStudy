package daily._2023._03;

import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/design-browser-history/solutions/3309557/image-explanation-both-array-stack-approaches-c-java-python/
//ArrayList or Stack으로 다시 접근해보기
public class Day_18_Sat {
    static class BrowserHistory {

        public BrowserHistory(String homepage) {
        }

        public void visit(String url) {
        }

        public String back(int steps) {
            return "";
        }

        public String forward(int steps) {
            return "";
        }
    }

    @Test
    void test() {
        // [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com"); // 현재 "leetcode.com"에 있습니다. "google.com" 방문
        browserHistory.visit("facebook.com"); // 현재 "google.com"에 있습니다. "facebook.com" 방문하기
        browserHistory.visit("youtube.com"); // 현재 "facebook.com"에 있습니다. "youtube.com" 방문하기
        System.out.println(browserHistory.back(1)); // 현재 "youtube.com"에 있습니다. "facebook.com"으로 돌아가십시오. return "facebook.com"
        System.out.println(browserHistory.back(1)); // 현재 "facebook.com"에 있습니다. "google.com"으로 돌아가서 "google.com"을 반환합니다.
        System.out.println(browserHistory.forward(1)); // 현재 "google.com"에 있습니다. 앞으로 "facebook.com"으로 이동합니다. return "facebook.com"

        browserHistory.visit("linkedin.com"); // 현재 "facebook.com"에 있습니다. "linkedin.com" 방문

        System.out.println(browserHistory.forward(2)); // 귀하는 "linkedin.com"에 있으며 어떤 단계도 진행할 수 없습니다.
        System.out.println(browserHistory.back(2)); // 현재 "linkedin.com"에 있습니다. "facebook.com"으로 두 단계 뒤로 이동한 다음 "google.com"으로 이동합니다. "google.com" 반환
        System.out.println(browserHistory.back(7)); // 현재 "google.com"에 있으며 "leetcode.com"으로 한 단계만 뒤로 이동할 수 있습니다. "leetcode.com" 반환

        // g -> f -> y -> l
    }
}
