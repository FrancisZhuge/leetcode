package com.francis.leetcode.p220_containsNearbyAlmostDuplicate;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            Integer ceiling = record.ceiling(value);
            if (ceiling != null && value >= ceiling - t) return true;
            Integer floor = record.floor(value);
            if (floor != null && value <= floor + t) return true;

            record.add(value);
            if (record.size() > k) {
                record.remove(nums[i - k]);
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums_1 = {1, 2, 3, 1};
        System.out.println(containsNearbyAlmostDuplicate(nums_1, 3, 0));

        int[] nums_2 = {1, 0, 1, 1};
        System.out.println(containsNearbyAlmostDuplicate(nums_2, 1, 2));

        int[] nums_3 = {1, 5, 9, 1, 5, 9};
        System.out.println(containsNearbyAlmostDuplicate(nums_3, 2, 3));
    }
}
