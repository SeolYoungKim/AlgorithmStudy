package daily._2023._04;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day_28 {
    static class UnionFind {
        int[] parent;
        int count;

        public UnionFind(final int count) {
            parent = new int[count];
            this.count = count;

            for (int i = 0; i < count; i++) {
                parent[i] = i;  // 1,2,3,4,5...i까지 채운다.
            }
        }

        public int find(int num) {  // x를 찾는다.
            if (parent[num] != num) {  // parent[num]의 값이 x와 다르다면 -> 어딘가에 연결되어 있다는 소리다.
                parent[num] = find(parent[num]);  // parent[num]의 값을 기반으로 다시 찾는다.
            }
            return parent[num];  // parent[num] == x인 경우가 집합의 루트다. 이를 반환한다. 처음에 find(num)를 한 x의 집합이 구해지는 원리다.
        }

        public void union(int x, int y) {
            int rootX = find(x);  // x의 루트를 찾는다.
            int rootY = find(y);  // y의 루트를 찾는다.

            if (rootX != rootY) {  // x와 y가 서로 다르면 집합이 아니기 때문에 합집합을 수행함
                parent[rootY] = rootX;
                count--;  // 합집합을 수행하면 카운트를 줄인다. (카운트 초깃값은 글자의 개수임)
            }
        }
    }

    public int numSimilarGroups(String[] strs) {
        // 유사성을 찾는 메서드
        final int n = strs.length;
        final UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    // 비슷하면 그룹에...
                    unionFind.union(i, j);
                }
            }
        }

        return unionFind.count;
    }

    private boolean isSimilar(final String str1, final String str2) {
        if (str1.equals(str2)) {
            return true;
        }

        int count = 0;
        final int length = str1.length();

        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }

        return count == 2;
    }

    @Test
    void test() {
        assertThat(numSimilarGroups(new String[]{"tars", "rats", "arts", "star"})).isEqualTo(2);
        assertThat(numSimilarGroups(new String[]{"omv","ovm"})).isEqualTo(1);
    }
}
