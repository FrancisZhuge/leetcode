package com.francis.leetcode.problem_201_250.problem215_findKthLargest;

import org.junit.Test;

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
 * 快速排序的partition操作。
 * <p>
 * time:O(n)
 * space:O(logn)
 * <p>
 * 2ms
 * 41.6MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution3 {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    private int findKthLargest(int[] nums, int l, int r, int k) {
        if (l == r)
            return nums[l];
        int p = partition(nums, l, r);
        if (p == k) return nums[p];
        else if (k < p) return findKthLargest(nums, l, p - 1, k);
        else return findKthLargest(nums, p + 1, r, k);
    }

    private int partition(int[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        int v = arr[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && arr[i] < v) i++;
            while (j > l && arr[j] > v) j--;
            if (i > j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, j, l);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    @Test
    public void test() {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 2));
    }
}
