package com.francis.leetcode.problem_201_250.problem209_minSubArrayLen;

import org.junit.Test;

/**
 * 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，
 * 找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * 优化暴力求解
 * <p>
 * time:O(n^2)
 * space:O(n)
 * <p>
 * 191ms
 * 43MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution3 {

    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        sums[0] = 0;
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (sums[j + 1] - sums[i] >= s) {
                    ans = Math.min(ans, (j - i + 1));
                    break;
                }
            }
        }
        return (ans == Integer.MAX_VALUE ? 0 : ans);
    }

    @Test
    public void test() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }

}
