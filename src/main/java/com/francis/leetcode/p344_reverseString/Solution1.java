package com.francis.leetcode.p344_reverseString;

import org.junit.Test;

import java.util.Arrays;

/**
 * time : O(n)
 * space: O(1)
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int l = 0, r = s.length - 1;
        while (l < r) {
            swap(s, l, r);
            l++;
            r--;
        }
    }

    private void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }

    @Test
    public void test() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));

        char[] s_1 = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s_1);
        System.out.println(Arrays.toString(s_1));
    }
}
