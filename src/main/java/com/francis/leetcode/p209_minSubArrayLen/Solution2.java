package com.francis.leetcode.p209_minSubArrayLen;

import org.junit.Test;

/**
 * time:O(n^2)
 * space:O(n)
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

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
