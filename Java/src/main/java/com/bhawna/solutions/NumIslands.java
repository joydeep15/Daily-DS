package com.bhawna.solutions;

class NumIslands {
    
    void dfs(char[][] grid,int i,int j,int m,int n){
        
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]!='1')
            return;
        grid[i][j]='0';
        dfs(grid,i+1,j,m,n);
        dfs(grid,i,j+1,m,n);
        dfs(grid,i-1,j,m,n);
        dfs(grid,i,j-1,m,n);
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        if(m<1)
            return 0;
        int n=grid[0].length;
        int numIslands=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j,m,n);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
}
