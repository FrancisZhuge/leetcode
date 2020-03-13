package com.francis.leetcode.problem_251_300.problem283_moveZeroes;

import org.junit.Test;

import java.util.Arrays;

/**
 * time o(n)
 * space o(1)
 * <p>
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
 * Memory Usage: 42.5 MB, less than 5.59% of Java online submissions for Move Zeroes.
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution2 {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int k = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] != 0)
                nums[k++] = nums[i];
        for (int i = k; i < n; i++)
            nums[i] = 0;
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
