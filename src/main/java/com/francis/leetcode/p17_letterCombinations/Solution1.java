package com.francis.leetcode.p17_letterCombinations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    private String[] letterMap = {
            "",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;
        dfs(digits, 0, "", ans);
        return ans;
    }

    private void dfs(String digits, int index, String value, List<String> ans) {
        if (index == digits.length()) {
            ans.add(value);
            return;
        }
        String str = letterMap[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            dfs(digits, index + 1, value + str.charAt(i), ans);
        }
    }

    @Test
    public void test() {
        System.out.println(letterCombinations("23"));
    }
}
