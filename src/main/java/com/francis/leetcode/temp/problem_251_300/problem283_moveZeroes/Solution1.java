package com.francis.leetcode.problem_251_300.problem283_moveZeroes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * time o(n)
 * space o(n)
 * <p>
 * Runtime: 1 ms, faster than 20.66% of Java online submissions for Move Zeroes.
 * Memory Usage: 42.4 MB, less than 5.59% of Java online submissions for Move Zeroes.
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution1 {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (nums[i] != 0)
                temp.add(nums[i]);
        for (int i = 0; i < temp.size(); i++)
            nums[i] = temp.get(i);
        for (int i = temp.size(); i < n; i++)
            nums[i] = 0;
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
