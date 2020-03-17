package com.francis.leetcode.p147_insertionSortList;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = head;

        while (pre.next != null) {
            int val = pre.next.val;
            ListNode next = pre.next.next;
            ListNode pi = dummy;
            for (; pi != pre; pi = pi.next) {
                if (pi.next.val > val) {
                    ListNode pj = pi.next;
                    ListNode cur = pre.next;
                    pi.next = cur;
                    cur.next = pj;
                    pre.next = next;
                    break;
                }
            }
            if (pi == pre)
                pre = pre.next;
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode head = ListNodeUtils.createList(new int[]{4, 2, 1, 3});
        ListNodeUtils.printList(head);
        ListNodeUtils.printList(insertionSortList(head));
    }
}
