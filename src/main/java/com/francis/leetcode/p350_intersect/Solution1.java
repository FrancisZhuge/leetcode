package com.francis.leetcode.p350_intersect;

import org.junit.Test;

import java.util.*;

/**
 * time:O(m+n)
 * space:O(n)
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int key : nums1)
            record.put(key, record.getOrDefault(key, 0) + 1);
        List<Integer> ans = new ArrayList<>();
        for (int key : nums2) {
            Integer value = record.getOrDefault(key, 0);
            if (value > 0) {
                ans.add(key);
                record.put(key, value - 1);
            }
        }
        int[] result = new int[ans.size()];
        for (int l = 0; l < ans.size(); l++)
            result[l] = ans.get(l);
        return result;
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
