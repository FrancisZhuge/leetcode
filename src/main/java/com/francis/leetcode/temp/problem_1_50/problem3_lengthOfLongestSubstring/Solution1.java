package com.francis.leetcode.problem_1_50.problem3_lengthOfLongestSubstring;

import org.junit.Test;

/**
 * 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * time:O(n)
 * space:O(1)
 * <p>
 * 3ms
 * 39.9MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution1 {

    public int lengthOfLongestSubstring(String s) {
        int[] record = new int[256];
        int l = 0, r = -1;
        int ans = 0;
        while (r + 1 < s.length()) {
            if (record[s.charAt(r + 1)] == 0)
                record[s.charAt(++r)]++;
            else
                record[s.charAt(l++)]--;
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
