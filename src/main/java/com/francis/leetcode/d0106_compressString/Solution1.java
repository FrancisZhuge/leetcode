package com.francis.leetcode.d0106_compressString;

import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public String compressString(String S) {
        if (S == null || S.length() == 0) return S;
        char[] chars = S.toCharArray();
        String result = "";
        int count = 1;
        int k = 0;
        for (int i = 1; i < S.length(); i++) {
            if (chars[i] == chars[k]) {
                count++;
            } else {
                result = result + chars[k] + count;
                k = i;
                count = 1;
            }
        }
        result = result + chars[S.length() - 1] + count;
        return result.length() < S.length() ? result : S;
    }

    @Test
    public void test() {
        System.out.println(compressString("abbccd"));
    }
}
