package com.francis.leetcode.d1160_countCharacters;

import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int countCharacters(String[] words, String chars) {
        int[] record = new int[26];
        for (char c : chars.toCharArray())
            record[c - 'a']++;

        int len = 0;
        for (String word : words) {
            if (cover(word, record))
                len += word.length();
        }
        return len;
    }

    private boolean cover(String word, int[] record) {
        int[] wordRecord = new int[26];
        for (char c : word.toCharArray()) {
            wordRecord[c - 'a']++;
            if (wordRecord[c - 'a'] > record[c - 'a'])
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        // words = ["cat","bt","hat","tree"], chars = "atach"
        System.out.println(countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr"));
    }
}
