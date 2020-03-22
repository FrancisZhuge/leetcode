package com.francis.leetcode.p93_restoreIpAddresses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) return ans;
        LinkedList<Integer> ips = new LinkedList<>();
        ips.addLast(s.charAt(0) - '0');
        backtrack(s, 1, ips, ans);
        return ans;
    }

    private void backtrack(String s, int index, LinkedList<Integer> ips, List<String> ans) {
        if (index == s.length()) {
            if (ips.size() == 4) ans.add(ip2String(ips));
            return;
        }
        int next = ips.getLast() * 10 + (s.charAt(index) - '0');
        if (next <= 255 && ips.getLast() > 0) {
            LinkedList<Integer> nextList = new LinkedList<>(ips);
            nextList.removeLast();
            nextList.addLast(next);
            backtrack(s, index + 1, nextList, ans);
        }
        if (ips.size() < 4) {
            ips.addLast(s.charAt(index) - '0');
            backtrack(s, index + 1, ips, ans);
        }
    }

    private String ip2String(List<Integer> ips) {
        String ans = ips.get(0) + "";
        for (int i = 1; i < ips.size(); i++) ans += "." + ips.get(i);
        return ans;
    }

    @Test
    public void test() {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("010010"));
    }
}
