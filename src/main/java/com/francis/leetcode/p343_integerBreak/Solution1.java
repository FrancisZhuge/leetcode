package com.francis.leetcode.p343_integerBreak;

import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int integerBreak(int n) {
        int[] record = new int[n + 1];
        record[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i / 2; j++)
                record[i] = Math.max(record[i], Math.max(j, record[j]) * Math.max(i - j, record[i - j]));
        return record[n];
    }

    @Test
    public void test(){
        System.out.println(integerBreak(2));
    }

}
