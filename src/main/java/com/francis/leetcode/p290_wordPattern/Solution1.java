package com.francis.leetcode.p290_wordPattern;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] split = str.split(" ");
        if (chars.length != split.length) return false;
        Map<Character, String> record = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            char key = chars[i];
            String value = split[i];
            if (!record.containsKey(key)) {

                if (record.containsValue(value))
                    return false;
                record.put(key, value);
            } else {
                if (!record.get(key).equals(value))
                    return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(wordPattern(pattern, str));

        pattern = "abba";
        str = "dog dog dog dog";
        System.out.println(wordPattern(pattern, str));
    }
}
