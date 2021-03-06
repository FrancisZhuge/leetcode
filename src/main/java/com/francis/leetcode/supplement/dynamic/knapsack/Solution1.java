package com.francis.leetcode.supplement.dynamic.knapsack;

import org.junit.Test;

/**
 * 0-1背包问题
 * <p>
 * 有一个背包，容量C(Capacity)。现在有n中不同的物品，编号为0,...,n-1
 * 其中每一件物品的重量为w(i)，价值为v(i)。问可以向这个背包中盛放那些物品，使得在不超过背包容量的基础上，物品的总价值最大。
 * <p>
 * F(n,C)考虑将n个物品放进容量为C的背包，使得价值最大
 * F(i,C) = max ( F(i-1,C) , v(i) + F(i-1,c-w(i)) )
 *
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int knapsack(int[] w, int[] v, int c) {
        int n = w.length;
        return bestValue(w, v, n - 1, c);
    }

    /**
     * 用[0,...,index]物品，填充容积为c的背包的最大值
     */
    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0)
            return 0;
        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index])
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        return res;
    }

    @Test
    public void test() {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        System.out.println(knapsack(w, v, 5));
    }
}
