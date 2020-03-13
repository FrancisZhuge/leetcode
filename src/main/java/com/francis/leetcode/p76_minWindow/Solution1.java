package com.francis.leetcode.p76_minWindow;

import org.junit.Test;

/**
 * time:O(n)
 * space:O(1)
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public String minWindow(String s, String t) {
        int s_n = s.length();
        int t_n = t.length();

        int[] record_t = new int[256];
        for (char c : t.toCharArray())
            record_t[c]++;

        int[] record_s = new int[256];
        int l = 0, r = -1, count = 0, minIndex = -1, minLen = Integer.MAX_VALUE;
        while (l < s_n) {
            if (r + 1 < s_n && count < t_n) {
                record_s[s.charAt(++r)]++;
                if (record_s[s.charAt(r)] <= record_t[s.charAt(r)])
                    count++;
            } else {
                if (count == t_n && (r - l + 1) < minLen) {
                    minIndex = l;
                    minLen = r - l + 1;
                }
                record_s[s.charAt(l)]--;
                if (record_s[s.charAt(l)] < record_t[s.charAt(l)])
                    count--;
                l++;
            }
        }
        return minIndex == -1 ? "" : s.substring(minIndex, minIndex + minLen);
    }

    @Test
    public void test() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
