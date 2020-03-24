package com.francis.leetcode.p62_uniquePaths;

import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int uniquePaths(int m, int n) {
        int[][] record = new int[m][n];
        for (int i = 0; i < m; i++)
            record[i][0] = 1;
        for (int j = 1; j < n; j++)
            record[0][j] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                record[i][j] = record[i - 1][j] + record[i][j - 1];
        return record[m - 1][n - 1];
    }

    @Test
    public void test() {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
    }

}
