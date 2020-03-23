package com.francis.leetcode.p130_solve;

import com.francis.leetcode.utils.Utils;
import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        int[][] direct = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        List<Pair<Integer, Integer>> record = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j] && dfs(board, direct, visited, record, m, n, i, j)) {
                    for (Pair<Integer, Integer> pair : record)
                        board[pair.getKey()][pair.getValue()] = 'X';
                }
                record.clear();
            }
    }

    private boolean dfs(char[][] board, int[][] direct, boolean[][] visited, List<Pair<Integer, Integer>> record, int m, int n, int startX, int startY) {
        record.add(new Pair<>(startX, startY));
        visited[startX][startY] = true;
        boolean ans = true;
        if (isBorder(startX, startY, m, n)) ans = false;
        for (int i = 0; i < 4; i++) {
            int newX = startX + direct[i][0];
            int newY = startY + direct[i][1];
            if (inArea(newX, newY, m, n) && !visited[newX][newY] && board[newX][newY] == 'O')
                ans = dfs(board, direct, visited, record, m, n, newX, newY) && ans;
        }
        return ans;
    }

    private boolean isBorder(int i, int j, int m, int n) {
        return i == 0 || i == m - 1 || j == 0 || j == n - 1;
    }

    private boolean inArea(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    @Test
    public void test() {
//        char[][] board = {
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}
//        };
//        Utils.print2Arrays(board);
//        solve(board);
//        Utils.print2Arrays(board);
        char[][] board_1 = {
                {'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'X'},
                {'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O'}};
        Utils.print2Arrays(board_1);
        solve(board_1);
        Utils.print2Arrays(board_1);


        char[][] board_2 =
                {{'X', 'O', 'X', 'X'}, {'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X'}};
        Utils.print2Arrays(board_2);
        solve(board_2);
        Utils.print2Arrays(board_2);
    }
}
