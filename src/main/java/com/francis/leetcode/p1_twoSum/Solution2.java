package com.francis.leetcode.p1_twoSum;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.containsKey(target - nums[i]))
                return new int[]{i, record.get(target - nums[i])};
            else
                record.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
