package com.francis.leetcode.p143_reorderList;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (head1 != null) {
            cur.next = head1;
            head1 = head1.next;
            cur = cur.next;

            cur.next = head2;
            head2 = head2.next;
            cur = cur.next;
        }
        if (head2 != null)
            cur.next = head2;
        head = dummy.next;
    }


    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    @Test
    public void test() {
        ListNode head = ListNodeUtils.createList(new int[]{1, 2, 3, 4});
        ListNodeUtils.printList(head);
        reorderList(head);
        ListNodeUtils.printList(head);

        head = ListNodeUtils.createList(new int[]{1, 2, 3, 4, 5});
        ListNodeUtils.printList(head);
        reorderList(head);
        ListNodeUtils.printList(head);
    }
}
