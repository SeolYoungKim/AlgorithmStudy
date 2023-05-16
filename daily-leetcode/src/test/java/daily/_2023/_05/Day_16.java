package daily._2023._05;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Day_16 {
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

        @Override
        public String toString() {
            return "[" + val + "]";
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = curr;

            if (prev != null) {
                prev.next = next;
            }

            prev = curr;
            curr = curr.next;
        }

        return newHead;
    }

    @Test
    void test() {
        final ListNode head = new ListNode(1);
        final ListNode next1 = new ListNode(2);
        final ListNode next2 = new ListNode(3);
        final ListNode next3 = new ListNode(4);

        head.next = next1;
        next1.next = next2;
        next2.next = next3;

        final ListNode listNode = swapPairs(head);

        print(listNode);
    }

    @Test
    void test2() {
        final ListNode head = new ListNode(1);
        final ListNode next1 = new ListNode(2);
        final ListNode next2 = new ListNode(3);

        head.next = next1;
        next1.next = next2;

        final ListNode listNode = swapPairs(head);
        print(listNode);
    }

    private void print(final ListNode listNode) {
        ListNode node = listNode;
        while (node.next != null) {
            System.out.println(node);
            node = node.next;
        }
    }
}
