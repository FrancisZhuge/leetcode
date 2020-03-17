package com.francis.leetcode.p445_addTwoNumbers;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int mod = 0;
        Stack<Integer> sum = new Stack<>();
        while (!stack1.empty() && !stack2.empty()) {
            int val = stack1.pop() + stack2.pop() + mod;
            sum.push(val % 10);
            mod = val / 10;
        }
        while (!stack1.empty()) {
            int val = stack1.pop() + mod;
            sum.push(val % 10);
            mod = val / 10;
        }
        while (!stack2.empty()) {
            int val = stack2.pop() + mod;
            sum.push(val % 10);
            mod = val / 10;
        }
        if (mod > 0) sum.push(mod);

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!sum.empty()) {
            cur.next = new ListNode(sum.pop());
            cur = cur.next;
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode l1 = ListNodeUtils.createList(new int[]{7, 2, 4, 3});
        ListNode l2 = ListNodeUtils.createList(new int[]{5, 6, 4});
        ListNodeUtils.printList(l1);
        ListNodeUtils.printList(l2);
        ListNodeUtils.printList(addTwoNumbers(l1, l2));
    }
}
