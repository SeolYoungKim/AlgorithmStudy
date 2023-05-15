package daily._2023._05;

import org.junit.jupiter.api.Test;

public class Day_15 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapNodes(ListNode head, int k) {
        // ListNode total count
        ListNode listNode = head;
        int totalCount = 1;
        while (listNode.next != null) {
            listNode = listNode.next;
            totalCount++;
        }

        ListNode firstNode = find(head, k - 1);
        ListNode secondNode = find(head, totalCount - k);

        final int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

        return head;
    }

    // n번째 노드를 찾는 메서드
    private ListNode find(ListNode head, int n) {
        ListNode findNode = head;
        for (int i = 0; i < n; i++) {
            findNode = findNode.next;
        }

        return findNode;
    }

    @Test
    void test() {
        final ListNode head = new ListNode(1);
        final ListNode next1 = new ListNode(2);
        final ListNode next2 = new ListNode(3);
        final ListNode next3 = new ListNode(4);
        final ListNode next4 = new ListNode(5);

        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;

        print(head, 5);

        swapNodes(head, 2);
        print(head, 5);
    }

    @Test
    void test2() {
        //[7,9,6,6,7,8,3,0,9,5]
        final ListNode head = new ListNode(7);
        final ListNode next1 = new ListNode(9);
        final ListNode next2 = new ListNode(6);
        final ListNode next3 = new ListNode(6);
        final ListNode next4 = new ListNode(7);
        final ListNode next5 = new ListNode(8);
        final ListNode next6 = new ListNode(3);
        final ListNode next7 = new ListNode(0);
        final ListNode next8 = new ListNode(9);
        final ListNode next9 = new ListNode(5);


        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next5;
        next5.next = next6;
        next6.next = next7;
        next7.next = next8;
        next8.next = next9;

        print(head, 10);

        swapNodes(head, 5);
        print(head, 10);
    }

    @Test
    void test3() {
        final ListNode head = new ListNode(1);
        final ListNode next1 = new ListNode(2);

        head.next = next1;
        print(head, 2);

        swapNodes(head, 1);
        print(head, 2);
    }

    private void print(final ListNode head, final int count) {
        ListNode listNode = head;
        for (int i = 0; i < count; i++) {
            if (listNode == null) {
                System.out.println("null");
                continue;
            }
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
