package com.francis.leetcode.problem_201_250.prblem242_isAnagram;

import org.junit.Test;

/**
 * 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * time:O(n)
 * space:O(n)
 * <p>
 * 3ms
 * 39.3MB
 *
 * @author zhugequn
 */
public class Solution1 {

    public boolean isAnagram(String s, String t) {
        int[] record_s = new int[26];
        for (char c : s.toCharArray())
            record_s[c - 'a']++;
        int[] record_t = new int[26];
        for (char c : t.toCharArray())
            record_t[c - 'a']++;
        for (int i = 0; i < 26; i++)
            if (record_s[i] != record_t[i])
                return false;
        return true;
    }

    @Test
    public void test() {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));

        s = "rat";
        t = "car";
        System.out.println(isAnagram(s, t));
    }
}
