package com.francis.leetcode.p64_minPathSum;

import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int j = 1; j < n; j++)
            grid[0][j] = grid[0][j] + grid[0][j - 1];
        for (int i = 1; i < m; i++)
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
        return grid[m - 1][n - 1];
    }

    @Test
    public void test() {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(minPathSum(grid));

        int[][] grid_1 = {
                {1, 2, 5},
                {3, 2, 1}};
        System.out.println(minPathSum(grid_1));
    }
}
