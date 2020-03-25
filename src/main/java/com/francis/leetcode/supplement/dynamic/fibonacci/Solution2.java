package com.francis.leetcode.supplement.dynamic.fibonacci;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        fib(memo, n);
        return memo[n];
    }

    private int fib(int[] memo, int n) {
        if (memo[n] == -1) {
            memo[n] = fib(memo, n - 1) + fib(memo, n - 2);
        }
        return memo[n];
    }

    @Test
    public void test() {
        for (int i = 1000; i < 10001; i++) {
            long start = System.currentTimeMillis();
            int res = fib(i);
            System.out.println("fib(" + i + ") = " + res + " time: " + (System.currentTimeMillis() - start) + "ms");
        }
    }
}
