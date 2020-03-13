package com.francis.leetcode.p11_maxArea;

import org.junit.Test;

/**
 * time:O(n^2)
 * space:O(1)
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
        return max;
    }

    @Test
    public void test() {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
