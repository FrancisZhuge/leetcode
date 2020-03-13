package com.francis.leetcode.problem_51_100.problem88_merge;

import org.junit.Test;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * Time: O(n)
 * Space:O(n)
 * <p>
 * 0ms
 * 39.2MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution1 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = Arrays.copyOfRange(nums1, 0, m + 1);
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n)
            if (temp[i] < nums2[j])
                nums1[k++] = temp[i++];
            else
                nums1[k++] = nums2[j++];
        while (i < m)
            nums1[k++] = temp[i++];
        while (j < n)
            nums1[k++] = nums2[j++];
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

}
