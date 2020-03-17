package com.francis.leetcode.p217_containsDuplicate;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> record = new HashSet<>();
        for (int item : nums) {
            if (record.contains(item)) return true;
            record.add(item);
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums_1 = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums_1));

        int[] nums_2 = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums_2));

        int[] nums_3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums_3));
    }
}
