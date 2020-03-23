package com.francis.leetcode.p417_pacificAtlantic;

import com.francis.leetcode.utils.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ans;

        int m = matrix.length, n = matrix[0].length;
        boolean[][] a = new boolean[m][n];
        boolean[][] b = new boolean[m][n];
        int[][] direct = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 0; i < m; i++) {
            dfs(matrix, direct, a, m, n, i, 0);
            dfs(matrix, direct, b, m, n, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(matrix, direct, a, m, n, 0, j);
            dfs(matrix, direct, b, m, n, m - 1, j);
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] && b[i][j])
                    ans.add(Arrays.asList(i, j));
        return ans;
    }

    private void dfs(int[][] matrix, int[][] direct, boolean[][] visited, int m, int n, int startX, int startY) {
        visited[startX][startY] = true;
        for (int i = 0; i < 4; i++) {
            int newX = startX + direct[i][0];
            int newY = startY + direct[i][1];
            if (inArea(newX, newY, m, n) && !visited[newX][newY] && matrix[newX][newY] >= matrix[startX][startY])
                dfs(matrix, direct, visited, m, n, newX, newY);
        }
    }

    private boolean inArea(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    @Test
    public void test() {
        int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        Utils.print2Arrays(matrix);
        System.out.println(pacificAtlantic(matrix));
    }
}
