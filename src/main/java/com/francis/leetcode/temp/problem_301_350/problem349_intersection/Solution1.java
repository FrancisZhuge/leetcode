package com.francis.leetcode.temp.problem_301_350.problem349_intersection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * <p>
 * time:O(n)
 * space:O(n)
 * <p>
 * 3ms
 * 40.3MB
 *
 * @author hzzhugequn@corp.netease.com
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
        for (int item : ans)
            result[i++] = item;
        return result;
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
