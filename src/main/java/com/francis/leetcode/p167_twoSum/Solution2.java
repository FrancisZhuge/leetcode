package com.francis.leetcode.p167_twoSum;

import org.junit.Test;

import java.util.Arrays;

/**
 * time:O(nlogn)
 * space:O(1)
 *
 * @author zhugequn
 */
public class Solution2 {

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            if (numbers[i] > target) break;
            int j = binarySearch(numbers, i + 1, n - 1, target - numbers[i]);
            if (j != -1)
                return new int[]{i + 1, j + 1};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] arr, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    @Test
    public void test() {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));
    }
}
