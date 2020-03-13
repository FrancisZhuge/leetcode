package com.francis.leetcode.p75_sortColors;

import org.junit.Test;

import java.util.Arrays;

/**
 * time:O(n)
 * space:O(1)
 *
 * @author zhugequn
 */
public class Solution1 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int[] record = new int[3];
        for (int item : nums)
            record[item]++;
        int k = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < record[i]; j++)
                nums[k++] = i;
    }

    @Test
    public void test() {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
