package chapter_02.union_find;

import java.util.Arrays;

public class UnionFind {
    static int[] parent = {0, 1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(parent));
        union(1, 3); // -> 1과 3의 합집합을 만들었다.
        union(2, 4);
        union(1, 2);
        union(5, 6);
        union(2, 5);

        find(4);
        find(6);
        System.out.println(Arrays.toString(parent));
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
}
