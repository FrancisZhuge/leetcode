package com.francis.leetcode.p198_rob;

import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] record = new int[n + 2];
        record[0] = 0;
        record[1] = 0;
        for (int i = 0; i < n; i++) {
            record[i + 2] = Math.max(nums[i] + record[i], record[i + 1]);
        }
        return record[n + 1];
    }

    @Test
    public void test() {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }
}
