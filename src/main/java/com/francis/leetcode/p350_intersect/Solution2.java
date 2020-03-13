package com.francis.leetcode.p350_intersect;

import org.junit.Test;

import java.util.*;

/**
 * time:O(mlogm+nlogn)
 * space:O(n)
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length)
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            } else j++;
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
