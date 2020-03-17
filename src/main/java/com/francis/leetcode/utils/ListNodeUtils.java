package com.francis.leetcode.utils;

import com.francis.leetcode.utils.entity.ListNode;

/**
 * @author zhugequn
 * @since jdk8
 */
public class ListNodeUtils {

    public static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = node;
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            if (current.next == null)
                System.out.print(current.val);
            else
                System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println();
    }

    public static ListNode findList(ListNode head, int target) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == target) {
                return cur;
            }
            cur = cur.next;
        }
        throw new RuntimeException("not find");
    }
}
