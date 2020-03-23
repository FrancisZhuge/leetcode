package com.francis.leetcode.p200_numIslands;

import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[][] direct = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int m = grid.length, n = grid[0].length, count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, direct, visited, m, n, i, j);
                }
            }
        return count;
    }

    private void dfs(char[][] grid, int[][] direct, boolean[][] visited, int m, int n, int startX, int startY) {
        visited[startX][startY] = true;
        for (int i = 0; i < 4; i++) {
            int newX = startX + direct[i][0];
            int newY = startY + direct[i][1];
            if (inArea(newX, newY, m, n) && grid[newX][newY] == '1' && !visited[newX][newY])
                dfs(grid, direct, visited, m, n, newX, newY);
        }
    }

    private boolean inArea(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    @Test
    public void test() {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(grid1));

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid2));
    }
}
