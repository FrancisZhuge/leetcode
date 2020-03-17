package com.francis.leetcode.p328_oddEvenList;

import com.francis.leetcode.utils.ListNodeUtils;
import com.francis.leetcode.utils.entity.ListNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);

        ListNode oddCur = oddDummy;
        ListNode evenCur = evenDummy;

        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            index++;
            if (index % 2 == 1) {
                oddCur.next = cur;
                oddCur = oddCur.next;
            } else {
                evenCur.next = cur;
                evenCur = evenCur.next;
            }
            cur = cur.next;
        }
        evenCur.next = null;
        oddCur.next = evenDummy.next;
        return oddDummy.next;
    }

    @Test
    public void test() {
        ListNode head = ListNodeUtils.createList(new int[]{1, 2, 3, 4, 5});
        ListNodeUtils.printList(head);
        ListNodeUtils.printList(oddEvenList(head));

        head = ListNodeUtils.createList(new int[]{2, 1, 3, 5, 6, 4, 7});
        ListNodeUtils.printList(head);
        ListNodeUtils.printList(oddEvenList(head));
    }
}
