package com.francis.leetcode.problem_151_200.problem167_twoSum;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 二分查找
 * <p>
 * time:O(nlogn)
 * time:O(1)
 * <p>
 * 3ms
 * 42.9MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution3 {

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            int j = binarySearch(numbers, i + 1, n - 1, target - numbers[i]);
            if (j != -1)
                return new int[]{i + 1, j + 1};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] num, int l, int r, int target) {
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (num[mid] == target) return mid;
            else if (num[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    @Test
    public void test() {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));
    }
}
