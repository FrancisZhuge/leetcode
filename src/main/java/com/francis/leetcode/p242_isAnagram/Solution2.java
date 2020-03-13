package com.francis.leetcode.p242_isAnagram;

import org.junit.Test;

import java.util.Arrays;

/**
 * time:O(nlogn)
 * space:O(n)
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();
        Arrays.sort(s_chars);
        Arrays.sort(t_chars);
        return new String(s_chars).equals(new String(t_chars));
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
