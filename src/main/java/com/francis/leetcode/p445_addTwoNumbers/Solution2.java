package com.francis.leetcode.p445_addTwoNumbers;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int mod = 0;
        while (l1 != null && l2 != null) {
            int value = l1.val + l2.val + mod;
            cur.next = new ListNode(value % 10);
            cur = cur.next;
            mod = value / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int value = l1.val + mod;
            cur.next = new ListNode(value % 10);
            cur = cur.next;
            mod = value / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int value = l2.val + mod;
            cur.next = new ListNode(value % 10);
            cur = cur.next;
            mod = value / 10;
            l2 = l2.next;
        }
        if (mod > 0)
            cur.next = new ListNode(mod);
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head) {
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
        ListNode l1 = ListNodeUtils.createList(new int[]{7, 2, 4, 3});
        ListNode l2 = ListNodeUtils.createList(new int[]{5, 6, 4});
        ListNodeUtils.printList(l1);
        ListNodeUtils.printList(l2);
        ListNodeUtils.printList(addTwoNumbers(l1, l2));
    }
}
