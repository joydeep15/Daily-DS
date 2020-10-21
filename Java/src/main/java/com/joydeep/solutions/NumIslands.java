package com.joydeep.solutions;

import java.util.HashSet;
import java.util.Set;

public class NumIslands {


    public static void main(String[] args) {

        char[][] grid ={
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };

        System.out.println(numIslands(grid));

    }


    public static int numIslands(char[][] grid) {

        Set<String> visited = new HashSet<>();
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (visited.contains("" + i + "," + j) || grid[i][j] == '0') {
                    continue;
                } else {
                    numIslands++;
                    travel(grid, i, j, visited);
                }
            }
        }

        return numIslands;

    }

    private static void travel(char[][] grid, int i, int j, Set<String> visited) {

        if ( i<0 || j<0 || i >= grid.length || j >= grid[i].length ||
                grid[i][j] == '0' || visited.contains("" + i + "," + j)) {
            return;
        }

        visited.add("" + i + "," + j);
        travel(grid, i, j + 1, visited);
        travel(grid, i, j - 1, visited);
        travel(grid, i + 1, j, visited);
        travel(grid, i - 1, j, visited);


    }

}
