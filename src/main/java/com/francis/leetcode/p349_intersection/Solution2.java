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
public class Solution2 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> record1 = new HashSet<>();
        for (int item : nums1)
            record1.add(item);

        Set<Integer> record2 = new HashSet<>();
        for (int item : nums2)
            record2.add(item);

        record2.retainAll(record1);

        int[] result = new int[record2.size()];
        int i = 0;
        for (int item : record2) {
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
