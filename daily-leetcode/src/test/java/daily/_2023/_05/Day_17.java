package daily._2023._05;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.Deque;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day_17 {
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

    public int pairSum(ListNode head) {
        final Deque<ListNode> deque = new ArrayDeque<>();
        deque.add(head);

        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            deque.add(node);
        }

        int max = Integer.MIN_VALUE;
        while (!deque.isEmpty()) {
            final ListNode left = deque.removeFirst();
            final ListNode right = deque.removeLast();

            max = Math.max(max, left.val + right.val);
        }

        return max;
    }

    @Test
    void test() {
        final ListNode head = new ListNode(5);
        final ListNode node1 = new ListNode(4);
        final ListNode node2 = new ListNode(2);
        final ListNode node3 = new ListNode(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        assertThat(pairSum(head)).isEqualTo(6);
    }

    @Test
    void test2() {
        final ListNode head = new ListNode(4);
        final ListNode node1 = new ListNode(2);
        final ListNode node2 = new ListNode(2);
        final ListNode node3 = new ListNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        assertThat(pairSum(head)).isEqualTo(7);
    }

    @Test
    void test3() {
        final ListNode head = new ListNode(1);
        final ListNode node1 = new ListNode(100000);

        head.next = node1;

        assertThat(pairSum(head)).isEqualTo(100001);
    }
}
