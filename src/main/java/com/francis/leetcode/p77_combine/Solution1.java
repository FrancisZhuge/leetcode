package com.francis.leetcode.p77_combine;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] record = new int[n];
        for (int i = 0; i < n; i++) record[i] = i + 1;
        dfs(record, k, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] record, int k, int index, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == k) {
            ans.add(cur);
            return;
        }
        for (int i = index; record.length - i >= k - cur.size() && i < record.length; i++) {
            List<Integer> next = new ArrayList<>(cur);
            next.add(record[i]);
            dfs(record, k, i + 1, next, ans);
        }
    }

    @Test
    public void test() {
        System.out.println(combine(4, 2));
    }
}
