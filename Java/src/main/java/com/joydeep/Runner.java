package com.joydeep;

import com.joydeep.solutions.LRUCache;
import com.joydeep.solutions.SudokuSolver;

public class Runner {
    public static void main(String[] args) {

        SudokuSolver ss = new SudokuSolver();
        char[][] board ={{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};



        ss.solveSudoku(board);


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }
    }
}
