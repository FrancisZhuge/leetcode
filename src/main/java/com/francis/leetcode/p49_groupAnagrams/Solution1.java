package com.francis.leetcode.p49_groupAnagrams;

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

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> record = new HashMap<>();
        for (String str : strs) {
            String key = key(str);
            if (!record.containsKey(key))
                record.put(key, new ArrayList<>());
            record.get(key).add(str);
        }
        return new ArrayList<>(record.values());
    }

    private String key(String string) {
        int[] record = new int[26];
        for (char c : string.toCharArray())
            record[c - 'a']++;
        String ans = "";
        for (int item : record)
            ans = ans + item + "#";
        return ans;
    }

    @Test
    public void test() {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
