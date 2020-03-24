package com.francis.leetcode.p63_uniquePathsWithObstacles;

import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] record = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            record[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) break;
            record[0][j] = 1;
        }
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (obstacleGrid[i][j] == 1) record[i][j] = 0;
                else record[i][j] = record[i - 1][j] + record[i][j - 1];
        return record[m - 1][n - 1];
    }

    @Test
    public void test() {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
