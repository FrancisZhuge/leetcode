package com.francis.leetcode.p209_minSubArrayLen;

import org.junit.Test;

/**
 * time:O(n)
 * space:O(1)
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution4 {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null) return 0;
        int n = nums.length;
        if (n == 0) return 0;
        int l = 0, r = -1, sum = 0, ans = Integer.MAX_VALUE;
        while (r + 1 < n) {
            while (r + 1 < n && sum < s) sum += nums[++r];
            if (sum >= s)
                ans = Math.min(ans, (r - l + 1));
            while (l < n && sum >= s) {
                sum -= nums[l++];
                if (sum >= s)
                    ans = Math.min(ans, r - l + 1);
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
