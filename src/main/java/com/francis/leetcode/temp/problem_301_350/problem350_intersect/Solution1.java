package com.francis.leetcode.temp.problem_301_350.problem350_intersect;

import org.junit.Test;

import java.util.*;

/**
 * 两个数组的交集 II
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * <p>
 * time:
 * space:
 * <p>
 * 6ms
 * 39.6MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution1 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int item : nums1)
            record.put(item, record.getOrDefault(item, 0) + 1);
        List<Integer> ans = new ArrayList<>();
        for (int item : nums2) {
            Integer value = record.getOrDefault(item, 0);
            if (value > 0) {
                ans.add(item);
                record.put(item, value - 1);
            }
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
