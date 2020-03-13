package com.francis.leetcode.p215_findKthLargest;

import org.junit.Test;

import java.util.Map;
import java.util.PriorityQueue;

/**
 * time:O(nlogn)
 * space:O(1)
 *
 * @author zhugequn
 */
public class Solution3 {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    private int findKthLargest(int[] nums, int l, int r, int k) {
        if (l == r) return nums[l];
        int p = partition(nums, l, r);
        if (p == k) return nums[l];
        else if (p < k) return findKthLargest(nums, p + 1, r, k);
        else return findKthLargest(nums, l, p - 1, k);
    }

    private int partition(int[] nums, int l, int r) {
        swap(nums, l, (int) (Math.random() * (r - l + 1) + l));
        int v = nums[l];
        int i = l + 1, j = r;
        while (true) {
            while (nums[i] < v) i++;
            while (nums[j] > v) j--;
            if (i > j) break;
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, j, l);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
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
