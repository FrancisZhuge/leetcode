package com.francis.leetcode.p52_totalNQueens;

import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    private int ans = 0;

    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] dia1 = new boolean[2 * n - 1];
        boolean[] dia2 = new boolean[2 * n - 1];
        dfs(col, dia1, dia2, 0, n);
        return ans;
    }

    private void dfs(boolean[] col, boolean[] dia1, boolean[] dia2, int i, int n) {
        if (i == n) {
            ans++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!col[j] && !dia1[i + j] && !dia2[i - j + n - 1]) {
                col[j] = true;
                dia1[i + j] = true;
                dia2[i - j + n - 1] = true;
                dfs(col, dia1, dia2, i + 1, n);
                dia2[i - j + n - 1] = false;
                dia1[i + j] = false;
                col[j] = false;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(totalNQueens(4));
    }
}
