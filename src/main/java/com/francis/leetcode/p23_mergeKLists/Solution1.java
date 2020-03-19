package com.francis.leetcode.p23_mergeKLists;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        int mid = (r - l) / 2 + l;
        ListNode l1 = merge(lists, l, mid);
        ListNode l2 = merge(lists, mid + 1, r);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            cur.next = l1;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNodeUtils.printList(mergeKLists(new ListNode[]{ListNodeUtils.createList(new int[]{1, 4, 5}), ListNodeUtils.createList(new int[]{1, 3, 4}), ListNodeUtils.createList(new int[]{2, 6})}));
    }
}
