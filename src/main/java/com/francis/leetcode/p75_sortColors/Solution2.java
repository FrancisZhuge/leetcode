package com.francis.leetcode.p75_sortColors;

import org.junit.Test;

import java.util.Arrays;

/**
 * time:O(n)
 * space:O(1)
 *
 * @author zhugequn
 */
public class Solution2 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        int l = -1, r = n;
        int i = 0;
        while (i < r) {
            if (nums[i] == 0) {
                l++;
                swap(nums, l, i);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                r--;
                swap(nums, r, i);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test() {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
