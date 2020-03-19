package com.francis.leetcode.p347_topKFrequent;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int item : nums)
            record.put(item, record.getOrDefault(item, 0) + 1);

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
            queue.add(new Pair<>(entry.getKey(), entry.getValue()));
            if (queue.size() > k) queue.poll();
        }
        List<Integer> ans = new LinkedList<>();
        while (!queue.isEmpty())
            ans.add(0, queue.poll().getKey());
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }
}
