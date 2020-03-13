package com.francis.leetcode.problem_101_150.problem125_isPalindrome;

import org.junit.Test;

/**
 * 验证回文串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * time:O(n)
 * space:O(1)
 * <p>
 * 3ms
 * 39.3MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution1 {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int l = 0;
        int r = s.length() - 1;
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
        System.out.println(isPalindrome(" "));
    }

}
