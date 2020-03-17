package com.francis.leetcode.p206_reverseList;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode reverseList(ListNode head) {
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
        ListNode node = ListNodeUtils.createList(new int[]{1, 2, 3, 4, 5});
        ListNodeUtils.printList(node);
        ListNodeUtils.printList(reverseList(node));
    }
}
