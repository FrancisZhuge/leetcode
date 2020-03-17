package com.francis.leetcode.p2_addTwoNumbers;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int into = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            int val = cur1.val + cur2.val + into;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            into = val / 10;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while (cur1 != null) {
            int val = cur1.val + into;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            into = val / 10;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            int val = cur2.val + into;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            into = val / 10;
            cur2 = cur2.next;
        }

        if (into > 0)
            cur.next = new ListNode(into);
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode l1 = ListNodeUtils.createList(new int[]{2, 4, 3});
        ListNode l2 = ListNodeUtils.createList(new int[]{5, 6, 4});
        ListNodeUtils.printList(l1);
        ListNodeUtils.printList(l2);
        ListNodeUtils.printList(addTwoNumbers(l1, l2));
    }
}
