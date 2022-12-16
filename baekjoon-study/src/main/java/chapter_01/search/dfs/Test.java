package chapter_01.search.dfs;

import java.util.ArrayList;
import java.util.List;

public class Test {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        sum(1);
        System.out.println(list);
    }

    static void sum(int val) {
        list.add(val);
        if (val > 9) {
            return;
        }

        sum(++val);
    }
}
