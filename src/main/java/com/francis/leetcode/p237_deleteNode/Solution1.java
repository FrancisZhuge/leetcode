package com.francis.leetcode.p237_deleteNode;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    @Test
    public void test(){
        ListNode head = ListNodeUtils.createList(new int[]{4, 5, 1, 9});
        ListNodeUtils.printList(head);
        deleteNode(ListNodeUtils.findList(head, 1));
        ListNodeUtils.printList(head);
    }
}
