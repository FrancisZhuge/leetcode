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
public class Solution2 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int item : nums)
            record.put(item, record.getOrDefault(item, 0) + 1);

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> record.get(a) - record.get(b));
        for (int key : record.keySet()) {
            queue.add(key);
            if (queue.size() > k) queue.poll();
        }
        return new ArrayList<>(queue);
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }
}
