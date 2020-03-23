package com.francis.leetcode.p216_combinationSum3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(k, n, 1, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int k, int n, int index, int sum, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() >= k) {
            if (cur.size() == k && sum == n) {
                ans.add(cur);
            }
            return;
        }
        for (int i = index; i < 10; i++) {
            sum += i;
            if (sum > n) break;
            List<Integer> next = new ArrayList<>(cur);
            next.add(i);
            dfs(k, n, i + 1, sum, next, ans);
            sum -= i;
        }
    }

    @Test
    public void test() {
        System.out.println(combinationSum3(3, 7));
    }
}
