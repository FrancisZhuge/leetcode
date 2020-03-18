package com.francis.leetcode.p234_isPalindrome;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head1 = slow.next;
        slow.next = null;
        head1 = reverse(head1);

        while (head != null) {
            if (head.val != head1.val) return false;
            head = head.next;
            head1 = head1.next;
        }
        return true;
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
        ListNode head = ListNodeUtils.createList(new int[]{1, 2});
        ListNodeUtils.printList(head);
        System.out.println(isPalindrome(head));

        head = ListNodeUtils.createList(new int[]{1, 2, 2, 1});
        System.out.println(isPalindrome(head));
    }
}
