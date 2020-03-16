package com.francis.leetcode.p447_numberOfBoomerangs;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> record = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int dis = dis(points[i], points[j]);
                record.put(dis, record.getOrDefault(dis, 0) + 1);
            }
            for (int value : record.values())
                ans += value * (value - 1);
        }
        return ans;
    }

    private int dis(int[] pa, int pb[]) {
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) + (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

    @Test
    public void test() {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs(points));
    }
}
