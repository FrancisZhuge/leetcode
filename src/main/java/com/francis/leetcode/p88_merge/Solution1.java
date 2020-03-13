package com.francis.leetcode.p88_merge;

import org.junit.Test;

import java.util.Arrays;

/**
 * time:O(n)
 * space:O(n)
 *
 * @author zhugequn
 */
public class Solution1 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = Arrays.copyOfRange(nums1, 0, m + 1);
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (temp[i] < nums2[j]) nums1[k++] = temp[i++];
            else nums1[k++] = nums2[j++];
        }
        while (i < m) nums1[k++] = temp[i++];
        while (j < n) nums1[k++] = nums2[j++];
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
