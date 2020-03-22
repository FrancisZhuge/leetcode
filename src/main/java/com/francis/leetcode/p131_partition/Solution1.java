package com.francis.leetcode.p131_partition;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.length() == 0) return ans;
        LinkedList<String> strings = new LinkedList<>();
        strings.addLast(s.charAt(0) + "");
        partition(s, 1, strings, ans);
        return ans;
    }

    private void partition(String s, int index, LinkedList<String> strings, List<List<String>> ans) {
        if (s.length() == index) {
            ans.add(strings);
            return;
        }
        String next = strings.getLast();
        int i = index;
        boolean isPalindrome = false;
        for (; i < s.length(); i++) {
            next += s.charAt(i);
            if (palindrome(next)) {
                isPalindrome = true;
                break;
            }
        }
        if (isPalindrome) {
            LinkedList<String> nextString = new LinkedList<>(strings);
            nextString.removeLast();
            nextString.addLast(next);
            partition(s, i + 1, nextString, ans);
        }
        strings.addLast(s.charAt(index) + "");
        partition(s, index + 1, strings, ans);
    }

    private boolean palindrome(String s) {
        if (s.length() == 1) return true;
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        return true;
    }

    @Test
    public void test() {
//        System.out.println(partition("aab"));
        System.out.println(partition("efe"));
    }

}
