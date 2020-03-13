package com.francis.leetcode.p26_removeDuplicates;

import org.junit.Test;

/**
 * time:O(n)
 * space:O(1)
 *
 * @author zhugequn
 */
public class Solution1 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int k = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] != nums[k])
                nums[++k] = nums[i];
        return k + 1;
    }

    @Test
    public void test() {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }
}
