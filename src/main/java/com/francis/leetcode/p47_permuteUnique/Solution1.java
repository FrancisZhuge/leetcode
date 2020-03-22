package com.francis.leetcode.p47_permuteUnique;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0, visited, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int index, boolean[] visited, List<Integer> cur, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(cur);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                // 本质上说，规定了相同数据的访问顺序
                if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;
                List<Integer> next = new ArrayList<>(cur);
                next.add(nums[i]);
                visited[i] = true;
                dfs(nums, index + 1, visited, next, ans);
                visited[i] = false;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }
}
