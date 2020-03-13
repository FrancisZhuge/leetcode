package com.francis.leetcode.p438_findAnagrams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * time:O(n)
 * space:O(n)
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int s_n = s.length();
        int p_n = p.length();
        if (s_n < p_n) return ans;

        int[] freq_p = new int[26];
        for (char c : p.toCharArray())
            freq_p[c - 'a']++;

        int l = 0, r = -1;
        int[] freq_s = new int[26];
        while (r + 1 < s_n) {
            freq_s[s.charAt(++r) - 'a']++;
            if (r - l + 1 > p_n)
                freq_s[s.charAt(l++) - 'a']--;
            if (r - l + 1 == p_n && same(freq_p, freq_s))
                ans.add(l);
        }
        return ans;
    }

    private boolean same(int[] a, int[] b) {
        for (int i = 0; i < 26; i++)
            if (a[i] != b[i])
                return false;
        return true;
    }

    @Test
    public void test() {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));

        s = "abab";
        p = "ab";
        System.out.println(findAnagrams(s, p));
    }
}
