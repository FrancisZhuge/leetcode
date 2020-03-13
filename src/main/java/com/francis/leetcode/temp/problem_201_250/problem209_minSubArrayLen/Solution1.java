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
 * 2ms
 * 43.1MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution1 {

    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int l = 0, r = -1, sum = 0, ans = Integer.MAX_VALUE;
        while (r + 1 < n) {
            while (r + 1 < n && sum < s)
                sum += nums[++r];
            if (sum >= s)
                ans = Math.min(r - l + 1, ans);
            while (l <= r && sum >= s) {
                sum -= nums[l++];
                if (sum >= s)
                    ans = Math.min(r - l + 1, ans);
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
