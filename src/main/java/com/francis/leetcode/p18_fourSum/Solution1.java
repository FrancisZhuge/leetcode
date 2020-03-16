package com.francis.leetcode.p18_fourSum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j - 1 >= i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1, r = n - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (sum < target)
                        l++;
                    else
                        r--;
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
