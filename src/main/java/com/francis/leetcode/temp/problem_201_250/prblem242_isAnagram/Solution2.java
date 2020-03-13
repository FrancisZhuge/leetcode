package com.francis.leetcode.problem_201_250.prblem242_isAnagram;

import org.junit.Test;

import java.util.Arrays;

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
 * time:O(nlogn)
 * space:O(n)
 * <p>
 * 3ms
 * 41.6MB
 *
 * @author zhugequn
 */
public class Solution2 {

    public boolean isAnagram(String s, String t) {
        char[] chars_s = s.toCharArray();
        char[] chars_t = t.toCharArray();

        Arrays.sort(chars_s);
        Arrays.sort(chars_t);
        return new String(chars_s).equals(new String(chars_t));
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
