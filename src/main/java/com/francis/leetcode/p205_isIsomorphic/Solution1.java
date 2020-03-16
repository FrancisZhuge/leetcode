package com.francis.leetcode.p205_isIsomorphic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chars_s = s.toCharArray();
        char[] chars_t = t.toCharArray();
        Map<Character, Character> record = new HashMap<>();
        for (int i = 0; i < chars_s.length; i++) {
            char key = chars_s[i];
            char value = chars_t[i];
            if (record.containsKey(key)) {
                if (record.get(key) != value) return false;
            } else {
                if (record.containsValue(value)) return false;
                record.put(key, value);
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
