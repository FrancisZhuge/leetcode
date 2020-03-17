package com.francis.leetcode.p203_removeElements;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != val) {
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }
        pre.next = null;
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode head = ListNodeUtils.createList(new int[]{1, 2, 6, 3, 4, 5, 6});
        ListNodeUtils.printList(head);
        ListNodeUtils.printList(removeElements(head, 6));
    }
}
