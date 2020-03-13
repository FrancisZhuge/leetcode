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
 * 暴力求解
 * <p>
 * time:O(n^2)
 * time:O(1)
 * <p>
 * 82ms
 * 43.1MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution2 {

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (numbers[i] + numbers[j] == target)
                    return new int[]{i + 1, j + 1};
                else if (numbers[i] + numbers[j] > target)
                    break;
        return new int[]{-1, -1};
    }

    @Test
    public void test() {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));
    }
}
