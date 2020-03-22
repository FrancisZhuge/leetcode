package com.francis.leetcode.p39_combinationSum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            sum += candidates[i];
            if (sum > target) break;
            List<Integer> next = new ArrayList<>(cur);
            next.add(candidates[i]);
            dfs(candidates, target, i, sum, next, ans);
            sum -= candidates[i];
        }
    }

    @Test
    public void test() {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
