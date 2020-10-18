package com.joydeep.solutions;

public class UniqueWays {


    public static void main(String[] args) {
        System.out.println(uniquePaths(0, 1));
    }

    public static int uniquePaths(int m, int n) {

        if (m <= 1 || n<=1) {
            return 1;
        }


        int[][] maze = new int[m][n];

        for (int i = 0; i < m; i++) {
            maze[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            maze[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                maze[i][j] = maze[i - 1][j] + maze[i][j - 1];
            }
        }

        return maze[m - 1][n - 1];
    }
}
