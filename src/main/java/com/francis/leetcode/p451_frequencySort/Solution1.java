package com.francis.leetcode.p451_frequencySort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    @SuppressWarnings("unchecked")
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> record = new HashMap<>();
        int max = 0;
        for (char key : chars) {
            int value = record.getOrDefault(key, 0) + 1;
            max = Math.max(value, max);
            record.put(key, value);
        }

        List<Character>[] lists = new ArrayList[max + 1];
        for (Map.Entry<Character, Integer> entry : record.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (lists[value] == null) lists[value] = new ArrayList<>();
            lists[value].add(key);
        }

        int index = 0;
        for (int i = max; i > 0; i--) {
            List<Character> characters = lists[i];
            if (characters != null) {
                for (char c : characters) {
                    for (int j = 0; j < i; j++)
                        chars[index++] = c;
                }
            }
        }
        return new String(chars);
    }

    @Test
    public void test() {
        String s = "tree";
        System.out.println(frequencySort(s));

        s = "cccaaa";
        System.out.println(frequencySort(s));

        s = "Aabb";
        System.out.println(frequencySort(s));
    }
}
