package arraylistTest;

import java.util.ArrayList;

public class ArrTest {

    public static void main(String[] args) {

        ArrayList<String> arrList = new ArrayList<>();

        arrList.add("SpringBoot");
        arrList.add("Node.js");
        arrList.add("Django");
        arrList.add("Ruby on Rails");
        arrList.add("Laravel");

        System.out.println("기술 스택 get 조회 : " + arrList.get(0));
        System.out.println("기술 스택 index 조회 : " + arrList.indexOf("Node.js"));

        System.out.println("기술 스택 삭제 : " + arrList.remove("SpringBoot"));
        System.out.println("기술 스택 삭제 : " + arrList.remove(0));


    }
}
