package com.francis.leetcode.p242_isAnagram;

import org.junit.Test;

/**
 * time:O(n)
 * space:O(1)
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] record = new int[26];
        for (char c : s.toCharArray())
            record[c - 'a']++;
        for (char c : t.toCharArray())
            if (record[c - 'a'] == 0) return false;
            else record[c - 'a']--;
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
