package com.francis.leetcode.p61_rotateRight;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        int len = len(head);
        k = k % len;
        if (k == 0) return head;

        ListNode fast = head;
        for (int i = 0; i < k; i++) fast = fast.next;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        fast.next = head;
        return next;
    }

    private int len(ListNode head) {
        int ans = 0;
        while (head != null) {
            head = head.next;
            ans++;
        }
        return ans;
    }

    @Test
    public void test() {
        ListNodeUtils.printList(rotateRight(ListNodeUtils.createList(new int[]{1, 2, 3, 4, 5}), 2));
    }
}
