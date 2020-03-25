package com.francis.leetcode.p416_canPartition;

import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        sum /= 2;
        int n = nums.length;
        boolean[] record = new boolean[sum + 1];

        for (int i = 0; i < sum + 1; i++) record[i] = i == nums[0];
        for (int i = 1; i < n; i++) {
            for (int j = sum; j >= nums[i]; j--)
                record[j] = record[j] || record[j - nums[i]];
        }
        return record[sum];
    }

    @Test
    public void test() {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartition(new int[]{1, 2, 5}));
    }
}
