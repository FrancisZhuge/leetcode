package com.francis.leetcode.p11_maxArea;

import org.junit.Test;

/**
 * time:O(n)
 * space:O(1)
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int maxArea(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            if (height[l] < height[r]) {
                max = Math.max(max, (r - l) * height[l]);
                l++;
            } else {
                max = Math.max(max, (r - l) * height[r]);
                r--;
            }
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
