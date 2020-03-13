package com.francis.leetcode.problem_251_300.problem290_wordPattern;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 单词规律
 * <p>
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * <p>
 * time:O(n)
 * space:O(n)
 * <p>
 * 1ms
 * 37.3MB
 *
 * @author zhugequn
 */
public class Solution1 {

    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] arrays = str.split(" ");
        if (chars.length != arrays.length) return false;
        Map<Character, String> record = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (record.containsKey(chars[i])) {
                if (!arrays[i].equals(record.get(chars[i])))
                    return false;
            } else {
                if (record.containsValue(arrays[i]))
                    return false;
                record.put(chars[i], arrays[i]);
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
