package com.francis.leetcode.p219_containsNearbyDuplicate;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int value = nums[i];
            if (record.contains(value)) return true;
            record.add(value);
            if (record.size() == k + 1)
                record.remove(nums[i - k]);
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums_1 = {1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate(nums_1, 3));

        int[] nums_2 = {1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(nums_2, 1));

        int[] nums_3 = {1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(nums_3, 2));

    }
}
