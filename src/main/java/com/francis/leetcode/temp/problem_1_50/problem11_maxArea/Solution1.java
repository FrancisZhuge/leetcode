package com.francis.leetcode.problem_1_50.problem11_maxArea;

import org.junit.Test;

/**
 * 盛最多水的容器
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * time:O(n)
 * space:O(1)
 * <p>
 * 3ms
 * 41.8MB
 *
 * @author hzzhugequn@corp.netease.com
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
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
