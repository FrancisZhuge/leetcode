package com.francis.leetcode.p1_twoSum;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) return new int[]{i, j};
        return new int[]{-1, -1};
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
