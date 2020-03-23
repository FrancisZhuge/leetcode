package com.francis.leetcode.p90_subsetsWithDup;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int index, List<Integer> cur, List<List<Integer>> ans) {
        ans.add(cur);
        for (int i = index; i < nums.length; i++) {
            if ( i > index && nums[i] == nums[i - 1]) continue;
            List<Integer> next = new ArrayList<>(cur);
            next.add(nums[i]);
            dfs(nums, i + 1, next, ans);
        }
    }

    @Test
    public void test() {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }
}
