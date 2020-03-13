package com.francis.leetcode.p125_isPalindrome;

import org.junit.Test;

/**
 * time:O(n)
 * space:O(1)
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char cl = s.charAt(l);
            while (!isAorN(cl) && l < r) cl = s.charAt(++l);
            if (isBigA(cl))
                cl = toLower(cl);
            char cr = s.charAt(r);
            while (!isAorN(cr) && l < r) cr = s.charAt(--r);
            if (isBigA(cr))
                cr = toLower(cr);
            if (cl != cr) return false;
            l++;
            r--;
        }
        return true;
    }

    private boolean isAorN(char c) {
        return 'A' <= c && c <= 'Z' || 'a' <= c && c <= 'z' || '0' <= c && c <= '9';
    }

    private boolean isBigA(char c) {
        return 'A' <= c && c <= 'Z';
    }

    private char toLower(char c) {
        return (char) (c - 'A' + 'a');
    }

    @Test
    public void test() {
        String string = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(string));
        string = "race a car";
        System.out.println(isPalindrome(string));
    }
}
