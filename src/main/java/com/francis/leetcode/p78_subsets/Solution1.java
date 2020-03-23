package com.francis.leetcode.p78_subsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        dfs(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int index, List<Integer> cur, List<List<Integer>> ans) {
        ans.add(cur);
        for (int i = index; i < nums.length; i++) {
            List<Integer> next = new ArrayList<>(cur);
            next.add(nums[i]);
            dfs(nums, i + 1, next, ans);
        }
    }

    @Test
    public void test() {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
