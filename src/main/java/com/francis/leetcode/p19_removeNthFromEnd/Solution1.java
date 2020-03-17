package com.francis.leetcode.p19_removeNthFromEnd;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) fast = fast.next;
        ListNode slow = dummy;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    @Test
    public void test() {
        ListNodeUtils.printList(removeNthFromEnd(ListNodeUtils.createList(new int[]{1, 2, 3, 4, 5}), 2));
    }
}
