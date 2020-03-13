package com.francis.leetcode.temp.problem_401_450.problem438_findAnagrams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * <p>
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * 输出:
 * [0, 1, 2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * <p>
 * time:O(n)
 * space:O(1)
 * <p>
 * 17ms
 * 41.8MB
 *
 * @author hzzhugequn@corp.netease.com
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

        int[] freq_s = new int[26];
        int l = 0, r = -1;
        while (r + 1 < s_n) {
            freq_s[s.charAt(++r) - 'a']++;
            if (r - l + 1 > p_n)
                freq_s[s.charAt(l++) - 'a']--;
            if (r - l + 1 == p_n)
                if (same(freq_p, freq_s))
                    ans.add(l);
        }
        return ans;
    }

    private boolean same(int[] a, int[] b) {
        for (int i = 0; i < 26; i++)
            if (a[i] != b[i]) return false;
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
