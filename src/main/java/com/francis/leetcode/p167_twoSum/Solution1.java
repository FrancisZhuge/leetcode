package com.francis.leetcode.p167_twoSum;

import org.junit.Test;

import java.util.Arrays;

/**
 * time:O(n^2)
 * space:O(1)
 *
 * @author zhugequn
 */
public class Solution1 {

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (numbers[i] + numbers[j] == target)
                    return new int[]{i + 1, j + 1};
        return new int[]{-1, -1};
    }

    @Test
    public void test() {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));
    }
}
