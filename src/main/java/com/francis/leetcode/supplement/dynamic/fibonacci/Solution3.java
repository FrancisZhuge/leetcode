package com.francis.leetcode.supplement.dynamic.fibonacci;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution3 {

    public int fib(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++)
            memo[i] = memo[i - 1] + memo[i - 2];
        return memo[n];
    }

    @Test
    public void test() {
        for (int i = 1000; i < 1010; i++) {
            long start = System.currentTimeMillis();
            int res = fib(i);
            System.out.println("fib(" + i + ") = " + res + " time: " + (System.currentTimeMillis() - start) + "ms");
        }
    }
}
