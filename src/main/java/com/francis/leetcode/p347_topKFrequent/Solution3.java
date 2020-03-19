package com.francis.leetcode.p347_topKFrequent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution3 {

    @SuppressWarnings("unchecked")
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int item : nums)
            record.put(item, record.getOrDefault(item, 0) + 1);

        List<Integer>[] list = new ArrayList[nums.length + 1];
        for (Integer key : record.keySet()) {
            int value = record.get(key);
            if (list[value] == null) list[value] = new ArrayList<>();
            list[value].add(key);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = list.length - 1; i >= 0 && ans.size() < k; i--) {
            if (list[i] == null) continue;
            ans.addAll(list[i]);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }
}
