package com.francis.leetcode.p82_deleteDuplicates;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            int count = 0;
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
                count++;
            }
            if (count > 0) {
                ListNode next = cur.next;
                pre.next = next;
                cur = next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode node = ListNodeUtils.createList(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNodeUtils.printList(node);
        ListNodeUtils.printList(deleteDuplicates(node));

        node = ListNodeUtils.createList(new int[]{1, 2, 3, 3, 4, 4, 5, 5});
        ListNodeUtils.printList(node);
        ListNodeUtils.printList(deleteDuplicates(node));
    }
}
