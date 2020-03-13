package com.francis.leetcode.p283_moveZeroes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * time:O(n)
 * space:O(1)
 *
 * @author zhugequn
 */
public class Solution2 {

    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                nums[k++] = nums[i];
        for (; k < nums.length; k++)
            nums[k] = 0;
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
