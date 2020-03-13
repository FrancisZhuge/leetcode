package com.francis.leetcode.p283_moveZeroes;

import org.junit.Test;

import java.util.Arrays;

/**
 * time:O(n)
 * space:O(1)
 *
 * @author zhugequn
 */
public class Solution3 {

    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                swap(nums, i, k++);
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
