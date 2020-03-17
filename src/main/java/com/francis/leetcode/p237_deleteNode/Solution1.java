package com.francis.leetcode.p237_deleteNode;

import com.francis.leetcode.utils.entity.ListNode;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
