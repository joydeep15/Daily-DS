package com.joydeep.solutions;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        solveSudoku(board,0,0);
    }

    public boolean solveSudoku(char board[][], int row, int col) {

        if (row == 9) {
            return true;
        }

        if (col == 9) {
            return solveSudoku(board, row + 1, 0);
        }

        if (board[row][col] != '.') {
            return solveSudoku(board, row, col + 1);
        }

        for (int i = 1; i <= 9; i++) {
            if (isChoiceValid(board, row, col, i)) {
                board[row][col] = (char) ('0' + i);
                if (solveSudoku(board, row, col + 1)) {
                    return true;
                }
            }
        }

        //backtrack
        board[row][col] = '.';
        return false;

    }

    private boolean isChoiceValid(char[][] board, int row, int col, int target) {

        Set<Integer> choices = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            choices.add(i);
        }

        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] == '.') {
                continue;
            }

            choices.remove(Integer.parseInt("" + board[row][i]));
        }


        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == '.') {
                continue;
            }

            choices.remove(Integer.parseInt("" + board[i][col]));
        }


        for (int i = 3 * (row / 3); i < 3 * (row / 3) + 3; i++) {
            for (int j = 3 * (col / 3); j < 3 * (col / 3) + 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                choices.remove(Integer.parseInt("" + board[i][j]));
            }
        }

        return choices.contains(target);
    }


}
