package com.francis.leetcode.problem_201_250.problem205_isIsomorphic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串
 * <p>
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * <p>
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * <p>
 * time:O(n)
 * space:O(n)
 * <p>
 * 17ms
 * 39.1MB
 *
 * @author zhugequn
 */
public class Solution1 {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> record = new HashMap<>();
        char[] chars_s = s.toCharArray();
        char[] chars_t = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (record.containsKey(chars_s[i])) {
                if (record.get(chars_s[i]) != chars_t[i])
                    return false;
            } else {
                if (record.containsValue(chars_t[i]))
                    return false;
                record.put(chars_s[i], chars_t[i]);
            }
        }
        return true;
    }

    @Test
    public void test() {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));

        s = "foo";
        t = "bar";
        System.out.println(isIsomorphic(s, t));

        s = "paper";
        t = "title";
        System.out.println(isIsomorphic(s, t));
    }
}
