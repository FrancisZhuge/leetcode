package com.francis.leetcode.p37_solveSudoku;

import com.francis.leetcode.utils.Utils;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.') {
                    row[i][board[i][j] - '0'] = true;
                    col[j][board[i][j] - '0'] = true;
                    box[i / 3 * 3 + j / 3][board[i][j] - '0'] = true;
                }
        for (int i = 0; i < 81; i++) {
            if (board[i / 9][i % 9] == '.'){
                dfs(board, row, col, box, i);

            }
        }
    }

    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] box, int index) {
        if (index == 81) return true;

        // 找到下个等待填充的值
        int next = index + 1;
        for (; next < 81; next++) if (board[next / 9][next % 9] == '.') break;
        int x = index / 9;
        int y = index % 9;
        for (int i = 1; i <= 9; i++) {
            if (!row[x][i] && !col[y][i] && !box[x / 3 * 3 + y / 3][i]) {
                row[x][i] = true;
                col[y][i] = true;
                box[x / 3 * 3 + y / 3][i] = true;
                board[x][y] = (char) ('0' + i);
                if (dfs(board, row, col, box, next))
                    return true;
                row[x][i] = false;
                col[y][i] = false;
                box[x / 3 * 3 + y / 3][i] = false;
                board[x][y] = '.';
            }
        }
        return false;
    }


    @Test
    public void test() {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Utils.print2Arrays(board);
        solveSudoku(board);
        Utils.print2Arrays(board);
    }
}
