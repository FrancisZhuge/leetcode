package com.francis.leetcode.p215_findKthLargest;

import org.junit.Test;

import java.util.Arrays;

/**
 * time:O(nlogn)
 * space:O(1)
 *
 * @author zhugequn
 */
public class Solution1 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    @Test
    public void test() {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 2));
    }
}
