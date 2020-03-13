package com.francis.leetcode.p345_reverseVowels;

import org.junit.Test;

/**
 * time:O(n)
 * space:O(1)
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!isVowels(chars[l])) {
                l++;
                continue;
            }
            if (!isVowels(chars[r])) {
                r--;
                continue;
            }
            char v = chars[l];
            chars[l] = chars[r];
            chars[r] = v;
            l++;
            r--;
        }
        return new String(chars);
    }

    private boolean isVowels(char c) {
        return c == 'a'
                || c == 'e'
                || c == 'i'
                || c == 'o'
                || c == 'u'
                || c == 'A'
                || c == 'E'
                || c == 'I'
                || c == 'O'
                || c == 'U';
    }

    @Test
    public void test() {
        String string = "hello";
        System.out.println(reverseVowels(string));
        string = "leetcode";
        System.out.println(reverseVowels(string));
    }

}
