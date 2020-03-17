package com.francis.leetcode.p92_reverseBetween;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n - m < 1) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) pre = pre.next;

        ListNode left = pre;
        ListNode end = pre.next;
        ListNode right = null;
        ListNode start = null;
        pre = end;
        ListNode cur = end.next;
        for (int i = 0; i < n - m; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            start = pre;
            right = cur;
        }
        left.next = start;
        end.next = right;
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode head = ListNodeUtils.createList(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = reverseBetween(head, 2, 2);
        ListNodeUtils.printList(listNode);

    }
}
