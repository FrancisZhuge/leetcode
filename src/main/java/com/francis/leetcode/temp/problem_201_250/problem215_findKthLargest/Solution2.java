package com.francis.leetcode.problem_201_250.problem215_findKthLargest;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 堆排序，最小堆，控制堆的数量在k
 * <p>
 * time:O(nlogk)
 * space:O(k)
 * <p>
 * 6ms
 * 41MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution2 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int n : nums) {
            if (heap.size() != k)
                heap.add(n);
            else if (n > heap.peek()) {
                heap.poll();
                heap.add(n);
            }
        }
        return heap.poll();
    }

    @Test
    public void test() {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 2));
    }
}
