package com.francis.leetcode.p167_twoSum;

import org.junit.Test;

import java.util.Arrays;

/**
 * time:O(n)
 * space:O(1)
 *
 * @author zhugequn
 */
public class Solution3 {

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) return new int[]{l + 1, r + 1};
            else if (numbers[l] + numbers[r] < target) l++;
            else r--;
        }
        return new int[]{-1, -1};
    }

    @Test
    public void test() {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));
    }
}
