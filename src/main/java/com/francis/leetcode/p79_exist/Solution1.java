package com.francis.leetcode.p79_exist;

import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean exist(char[][] board, String word) {
        int[][] direct = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (dfs(board, word, direct, visited, m, n, i, j, 0)) return true;
        return false;
    }

    private boolean dfs(char[][] board, String word, int[][] direct, boolean[][] visited, int m, int n, int startX, int startY, int index) {
        if (index == word.length() - 1) return board[startX][startY] == word.charAt(index);
        if (board[startX][startY] == word.charAt(index)) {
            visited[startX][startY] = true;
            for (int i = 0; i < 4; i++) {
                int newX = startX + direct[i][0];
                int newY = startY + direct[i][1];
                if (inArea(newX, newY, m, n) && !visited[newX][newY] && dfs(board, word, direct, visited, m, n, newX, newY, index + 1))
                    return true;
            }
            visited[startX][startY] = false;
        }
        return false;
    }

    private boolean inArea(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    @Test
    public void test() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }
}
