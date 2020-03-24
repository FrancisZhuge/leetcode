package com.francis.leetcode.p213_rob;

import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] record1 = new int[n + 1];
        int[] record2 = new int[n + 1];

        record1[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            record1[i] = Math.max(nums[i - 1] + record1[i - 2], record1[i - 1]);
            record2[i] = Math.max(nums[i - 1] + record2[i - 2], record2[i - 1]);
        }
        return Math.max(record1[n - 1], record2[n]);
    }

    @Test
    public void test() {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }
}
