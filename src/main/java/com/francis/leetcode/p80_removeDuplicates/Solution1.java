package com.francis.leetcode.p80_removeDuplicates;

import org.junit.Test;

import java.util.Arrays;

/**
 * time:O(n)
 * space:O(1)
 *
 * @author zhugequn
 */
public class Solution1 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int n = nums.length;
        if (n <= 2) return n;
        int k = 0, count = 1;
        for (int i = 1; i < n; i++)
            if (nums[i] == nums[k]) {
                if (count < 2) {
                    count++;
                    nums[++k] = nums[i];
                }
            } else {
                count = 1;
                nums[++k] = nums[i];
            }
        return k + 1;
    }

    @Test
    public void test() {
        int[] arr = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}
