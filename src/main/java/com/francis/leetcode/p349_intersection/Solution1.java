package com.francis.leetcode.p349_intersection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * time:O(n)
 * space:O(n)
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> record = new HashSet<>();
        for (int item : nums1)
            record.add(item);

        Set<Integer> ans = new HashSet<>();
        for (int item : nums2)
            if (record.contains(item))
                ans.add(item);
        int[] result = new int[ans.size()];
        int i = 0;
        for (int item : ans) {
            result[i++] = item;
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
