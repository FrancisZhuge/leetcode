package com.francis.leetcode.temp.problem_301_350.problem345_reverseVowels;

import org.junit.Test;

/**
 * 反转字符串中的元音字母
 * <p>
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * <p>
 * time:O(n)
 * space:O(1)
 * <p>
 * 3ms
 * 42MB
 *
 * @author hzzhugequn@corp.netease.com
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
