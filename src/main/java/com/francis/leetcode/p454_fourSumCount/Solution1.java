package com.francis.leetcode.p454_fourSumCount;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;

        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int sum = C[i] + D[j];
                record.put(sum, record.getOrDefault(sum, 0) + 1);
            }

        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int sum = A[i] + B[j];
                ans += record.getOrDefault(-sum, 0);
            }
        return ans;
    }

    @Test
    public void test() {
        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        System.out.println(fourSumCount(a, b, c, d));
    }
}
