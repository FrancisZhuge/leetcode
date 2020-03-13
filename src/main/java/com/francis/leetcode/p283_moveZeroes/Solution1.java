package com.francis.leetcode.p283_moveZeroes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * time:O(n)
 * space:O(n)
 *
 * @author zhugequn
 */
public class Solution1 {

    public void moveZeroes(int[] nums) {
        List<Integer> record = new ArrayList<>();
        for (int item : nums)
            if (item != 0)
                record.add(item);
        int i = 0;
        for (; i < record.size(); i++)
            nums[i] = record.get(i);
        for (; i < nums.length; i++)
            nums[i] = 0;
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
