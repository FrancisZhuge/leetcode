package com.francis.leetcode.p21_mergeTwoLists;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null & l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            cur.next = l1;
            cur = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur.next = l2;
            cur = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode l1 = ListNodeUtils.createList(new int[]{1, 2, 4});
        ListNode l2 = ListNodeUtils.createList(new int[]{1, 3, 4});
        ListNodeUtils.printList(mergeTwoLists(l1, l2));
    }

}
