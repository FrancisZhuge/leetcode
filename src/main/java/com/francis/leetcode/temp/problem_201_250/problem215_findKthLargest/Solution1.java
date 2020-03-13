package com.francis.leetcode.problem_201_250.problem215_findKthLargest;

import org.junit.Test;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 系统排序，选择倒数第k个元素
 * <p>
 * time:O(nlogn)
 * space:O(1)
 * <p>
 * 2ms
 * 41.5MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution1 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    @Test
    public void test() {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 2));
    }
}
