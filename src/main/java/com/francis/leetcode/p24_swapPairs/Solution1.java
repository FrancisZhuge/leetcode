package com.francis.leetcode.p24_swapPairs;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            ListNode nextNext = cur.next.next;
            pre.next = next;
            next.next = cur;
            cur.next = nextNext;
            pre = cur;
            cur = nextNext;
        }
        return dummy.next;
    }

    @Test
    public void test() {
//        ListNodeUtils.printList(swapPairs(ListNodeUtils.createList(new int[]{1, 2, 3, 4})));
        ListNodeUtils.printList(swapPairs(ListNodeUtils.createList(new int[]{1})));
    }

}
