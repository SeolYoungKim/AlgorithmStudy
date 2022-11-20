package test;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> upResult = new ArrayList<>();
        upResult.add("O");
        upResult.add("O");
        upResult.add("O");

        String join = "[ " + String.join(" | ", upResult) + " ]";
        System.out.println(join);

    }
}
