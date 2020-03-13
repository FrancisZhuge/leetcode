package com.francis.leetcode.p3_lengthOfLongestSubstring;

import org.junit.Test;

/**
 * time:O(n)
 * space:O(1)
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] record = new int[256];
        int l = 0, r = -1, ans = Integer.MIN_VALUE;
        while (r + 1 < n) {
            if (record[s.charAt(r + 1)] > 0)
                record[s.charAt(l++)]--;
            else
                record[s.charAt(++r)]++;
            ans = Math.max(ans, (r - l + 1));
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
