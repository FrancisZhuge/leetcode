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
 * 4ms
 * 39.9MB
 *
 * @author hzzhugequn@corp.netease.com
 */
public class Solution2 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> record1 = new HashSet<>();
        for (int item : nums1)
            record1.add(item);
        Set<Integer> record2 = new HashSet<>();
        for (int item : nums2)
            record2.add(item);
        record1.retainAll(record2);
        int[] result = new int[record1.size()];
        int i = 0;
        for (int item : record1)
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
