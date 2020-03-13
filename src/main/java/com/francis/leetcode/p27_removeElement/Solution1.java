package com.francis.leetcode.p27_removeElement;

import org.junit.Test;

/**
 * time:O(n)
 * space:O(1)
 *
 * @author zhugequn
 */
public class Solution1 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int k = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] != val)
                nums[k++] = nums[i];
        return k;
    }

    @Test
    public void test() {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
