package com.francis.leetcode.p25_reverseKGroup;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while (cur != null) {
            int count = 1;
            while (cur != null && count < k) {
                cur = cur.next;
                count++;
            }
            if (cur == null)
                break;
            ListNode next = cur.next;
            ListNode start = pre.next;
            cur.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            cur = next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    @Test
    public void test() {
        ListNodeUtils.printList(reverseKGroup(ListNodeUtils.createList(new int[]{1, 2, 3, 4, 5}), 2));
        ListNodeUtils.printList(reverseKGroup(ListNodeUtils.createList(new int[]{1, 2, 3, 4, 5}), 3));
    }
}
