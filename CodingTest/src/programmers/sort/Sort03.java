package programmers.sort;

import java.util.Arrays;

public class Sort03 {

    public static void main(String[] args) {
        Sort03 sort03 = new Sort03();
        int[] citations = {88, 89};
        System.out.println(sort03.solution(citations));
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));

        int max = Integer.MIN_VALUE;

        // 0 1 3 3 3 5 6
        // 0 1 2 3 4 5 6
        // 0 : 7개 -> 0 이상인게 7개 (h=0, 0번 이상 인용된 논문 0편)
        // 1 : 6개 -> 1 이상인게 6개 (h=1, 1번 이상 인용된 논문 1편)

        // 88, 89 -> 2
        // 1 -> 1
//        for (int i = 0; i < citations.length; i++) {
//            int currCitation = citations[i];
//            int currLength = citations.length - i;
//            if (currCitation <= currLength) {
//                max = Math.max(currCitation, max);
//            }
//        }

        // 논문은 현재 개수까지만 보면 된다.
        // 0점부터 현재 개수까지 가능. ex: 7개가 모두 7점이면 hIndex=7
        for (int hIdx = 0; hIdx <= citations.length; hIdx++) {
            for (int j = 0; j < citations.length; j++) {
                int citation = citations[j];
                if (hIdx <= citation) {
                    int length = citations.length - j;
                    if (hIdx <= length) {
                        max = Math.max(hIdx, max);
                    }
                }
            }
        }

        // 0 1 2 3 4 5 6  >  length = 7
        // 이 풀이 이해가안되누;
        // 현재 숫자와 남은 길이를 비교해서, 둘 중 작은 값을 구한다. 작은 값이 h-index가 된다.
        for(int i = 0; i < citations.length; i++) {
            int smaller = Math.min(citations[i], citations.length - i);
            max = Math.max(max, smaller);
        }

        return max;
    }
}
