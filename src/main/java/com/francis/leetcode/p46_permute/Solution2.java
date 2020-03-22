package com.francis.leetcode.p46_permute;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        int n = nums.length;

        boolean[] visited = new boolean[n];
        dfs(nums, visited, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, boolean[] visited, int index, List<Integer> strings, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(strings);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                List<Integer> next = new ArrayList<>(strings);
                next.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited, index + 1, next, ans);
                visited[i] = false;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
