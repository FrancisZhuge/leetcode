package com.francis.leetcode.p20_isValid;

import org.junit.Test;

import java.util.Stack;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        int n = s.length();
        if (n % 2 == 1) return false;

        Stack<Character> record = new Stack<>();
        for (char c : s.toCharArray()) {
            if (n < record.size()) return false;
            if (c == '(' || c == '{' || c == '[') record.push(c);
            else {
                if (record.isEmpty()) return false;
                char match;
                if (c == ')') match = '(';
                else if (c == '}') match = '{';
                else match = '[';
                if (match != record.pop()) return false;
            }
            n--;
        }
        return record.isEmpty();
    }

    @Test
    public void test() {
        System.out.println(isValid("()"));
    }
}
