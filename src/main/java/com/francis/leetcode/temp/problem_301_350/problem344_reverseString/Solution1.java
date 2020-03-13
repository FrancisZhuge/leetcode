package com.francis.leetcode.temp.problem_301_350.problem344_reverseString;

import org.junit.Test;

import java.util.Arrays;

/**
 * 反转字符串
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * time:O(n)
 * space:O(1)
 * <p>
 * 1ms
 * 43.5MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution1 {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int l = 0, r = s.length - 1;
        while (l < r) {
            char v = s[l];
            s[l] = s[r];
            s[r] = v;
            l++;
            r--;
        }
    }

    @Test
    public void test() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
