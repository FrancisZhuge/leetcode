package com.francis.leetcode.p51_solveNQueens;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        boolean[] col = new boolean[n];
        boolean[] dia1 = new boolean[2 * n - 1];
        boolean[] dia2 = new boolean[2 * n - 1];
        List<Integer> row = new LinkedList<>();
        dfs(ans, col, dia1, dia2, row, 0, n);
        return ans;
    }

    private void dfs(List<List<String>> ans, boolean[] col, boolean[] dia1, boolean[] dia2, List<Integer> row, int i, int n) {
        if (i == n) {
            ans.add(generate(row, n));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!col[j] && !dia1[i + j] && !dia2[i - j + n - 1]) {
                row.add(j);
                col[j] = true;
                dia1[i + j] = true;
                dia2[i - j + n - 1] = true;
                dfs(ans, col, dia1, dia2, row, i + 1, n);
                dia2[i - j + n - 1] = false;
                dia1[i + j] = false;
                col[j] = false;
                row.remove(row.size() - 1);
            }
        }
    }

    private List<String> generate(List<Integer> row, int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[row.get(i)] = 'Q';
            ans.add(new String(chars));
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(solveNQueens(4));
    }
}
