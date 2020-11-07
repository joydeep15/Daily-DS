package com.joydeep.solutions;

public class ValidTicTac {

    public static void main(String[] args) {
        String[] board = {
//                "XXX","OOX","OOX"
                "XXX","XOO","OO "
        };

        System.out.println(validTicTacToe(board));
    }

    public static boolean validTicTacToe(String[] board) {

        int xCount = getCount(board, 'X');
        int oCount = getCount(board, 'O');

        boolean baseValid = xCount >= oCount && (xCount - oCount) <= 1;

        if (!baseValid) {
            return false;
        }

        boolean xWinning = isWinning(board, 'X');
        boolean oWinning = isWinning(board, 'O');

        if (xWinning) {
            if (oCount != xCount - 1) {
                return false;
            }
        } else if (oWinning) {
            if (oCount != xCount) {
                return false;
            }
        }

        return true;
    }

    private static boolean isWinning(String[] board, char x) {

        //check rows
        for (String s : board) {
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == x) {
                    count++;
                }
            }
            if (count == s.length()) {
                return true;
            }
        }

        //check cols
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board[i].length(); j++) {
                if (board[j].charAt(i) == x) {
                    count++;
                }
            }
            if (count == board.length) {
                return true;
            }
        }

        //left diagonal
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i].charAt(i) == x) {
                count++;
            }
        }

        if (count == board.length) {
            return true;
        }
        count = 0;

        //right diagonal
        int j = board.length - 1;
        for (int i = 0; i < board.length; i++, j--) {
            if (board[i].charAt(j) == x) {
                count++;
            }
        }


        if (count == board.length) {
            return true;
        }

        return false;
    }

    private static int getCount(String[] board, char c) {

        int count = 0;
        for (String row : board) {
            for (char cell : row.toCharArray()) {
                if (c == cell) {
                    count++;
                }
            }
        }
        return count;
    }
}
