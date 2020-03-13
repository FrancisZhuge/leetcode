package com.francis.leetcode.p215_findKthLargest;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * time:O(nlogn)
 * space:O(1)
 *
 * @author zhugequn
 */
public class Solution2 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int item : nums) {
            if (queue.size() != k)
                queue.add(item);
            else if (item > queue.peek()) {
                queue.poll();
                queue.add(item);
            }
        }
        return queue.peek();
    }

    @Test
    public void test() {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 2));
    }
}
