package com.francis.leetcode.p279_numSquares;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int numSquares(int n) {
        int[] record = new int[n + 1];
        Arrays.fill(record, Integer.MAX_VALUE);
        record[0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; i - j * j >= 0; j++)
                record[i] = Math.min(record[i], record[i - j * j] + 1);
        return record[n];
    }

    @Test
    public void test() {
        System.out.println(numSquares(7168));
    }
}
