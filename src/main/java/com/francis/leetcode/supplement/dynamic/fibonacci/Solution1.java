package com.francis.leetcode.supplement.dynamic.fibonacci;

import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    @Test
    public void test() {
        for (int i = 40; i < 45; i++) {
            long start = System.currentTimeMillis();
            int res = fib(i);
            System.out.println("fib(" + i + ") = " + res + " time: " + (System.currentTimeMillis() - start) + "ms");
        }
    }
}
