package com.francis.leetcode.p40_combinationSum2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] candidates, int target, int index, int sum, List<Integer> cur, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(cur);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            sum += candidates[i];
            if (sum > target) break;
            List<Integer> next = new ArrayList<>(cur);
            next.add(candidates[i]);
            dfs(candidates, target, i + 1, sum, next, ans);
            sum -= candidates[i];
        }
    }

    @Test
    public void test() {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

}
