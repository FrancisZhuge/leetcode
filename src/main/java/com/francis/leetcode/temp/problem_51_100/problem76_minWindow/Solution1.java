package com.francis.leetcode.problem_51_100.problem76_minWindow;

import org.junit.Test;

/**
 * 最小覆盖子串
 * <p>
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * <p>
 * time:O(n)
 * space:O(n)
 * <p>
 * 3ms
 * 40.1MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution1 {

    public String minWindow(String s, String t) {
        int s_n = s.length();
        int t_n = t.length();

        int[] freq_t = new int[256];
        for (char c : t.toCharArray())
            freq_t[c]++;

        int[] freq_s = new int[256];
        int l = 0, r = -1;
        int count = 0;
        int minIndex = -1;
        int minLen = s_n + 1;


        while (l < s_n) {
            if (r + 1 < s_n && count < t_n) {
                freq_s[s.charAt(r + 1)]++;
                if (freq_s[s.charAt(r + 1)] <= freq_t[s.charAt(r + 1)])
                    count++;
                r++;
            } else {
                if (count == t_n && (r - l + 1) < minLen) {
                    minLen = r - l + 1;
                    minIndex = l;
                }
                freq_s[s.charAt(l)]--;
                if (freq_s[s.charAt(l)] < freq_t[s.charAt(l)])
                    count--;
                l++;
            }
        }
        if (minIndex != -1)
            return s.substring(minIndex, minIndex + minLen);
        return "";
    }

    @Test
    public void test() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
