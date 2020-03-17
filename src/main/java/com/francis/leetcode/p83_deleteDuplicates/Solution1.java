package com.francis.leetcode.p83_deleteDuplicates;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode pre = head;
        ListNode cur = pre.next;

        while (cur != null) {
            if (cur.val == pre.val) cur = cur.next;
            else {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }
        pre.next = null;
        return head;
    }

    @Test
    public void test() {
        ListNodeUtils.printList(deleteDuplicates(ListNodeUtils.createList(new int[]{1, 1, 2})));
        ListNodeUtils.printList(deleteDuplicates(ListNodeUtils.createList(new int[]{1, 1, 2, 3, 3})));
    }

}
