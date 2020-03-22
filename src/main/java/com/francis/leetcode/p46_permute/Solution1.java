package com.francis.leetcode.p46_permute;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

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
            ans.add(new ArrayList<>(strings));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                strings.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited, index + 1, strings, ans);
                visited[i] = false;
                strings.remove(strings.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
