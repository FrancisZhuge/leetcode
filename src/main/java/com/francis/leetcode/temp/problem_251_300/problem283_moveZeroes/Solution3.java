package com.francis.leetcode.problem_251_300.problem283_moveZeroes;

import org.junit.Test;

import java.util.Arrays;

/**
 * time o(n)
 * space o(1)
 * <p>
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
 * Memory Usage: 42.3 MB, less than 5.59% of Java online submissions for Move Zeroes.
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution3 {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int k = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] != 0)
                swap(nums, k++, i);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
