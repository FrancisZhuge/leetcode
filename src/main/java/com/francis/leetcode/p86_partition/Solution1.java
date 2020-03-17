package com.francis.leetcode.p86_partition;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode partition(ListNode head, int x) {
        ListNode s_dummy = new ListNode(-1);
        ListNode b_dummy = new ListNode(-1);
        ListNode s_cur = s_dummy;
        ListNode b_cur = b_dummy;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                s_cur.next = cur;
                s_cur = s_cur.next;
            } else {
                b_cur.next = cur;
                b_cur = b_cur.next;
            }
            cur = cur.next;
        }
        b_cur.next = null;
        s_cur.next = b_dummy.next;
        return s_dummy.next;
    }

    @Test
    public void test() {
        ListNode head = ListNodeUtils.createList(new int[]{1, 4, 3, 2, 5, 2});
        ListNodeUtils.printList(head);
        ListNodeUtils.printList(partition(head, 3));
    }
}
