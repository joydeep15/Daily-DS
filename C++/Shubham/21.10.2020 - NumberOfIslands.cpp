class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        vector<vector<int>> sol;
        for(int i=0;i<grid.size();i++){
            vector<int> n;
            for(int j=0;j<grid[0].size();j++)
                n.push_back(-1);
            sol.push_back(n);
        }
        int islands=0;
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[0].size();j++){
                if(grid[i][j]=='1'&&sol[i][j]==-1){
                    islands++;
                    markIslands(grid,sol,islands,i,j);
                }
            }
        }
        return islands;
    }

    void markIslands(vector<vector<char>>& grid, vector<vector<int>>& sol, int islands, int i, int j){
        sol[i][j]=islands;
        if(inMat(grid,i+1,j)){
            if(grid[i+1][j]=='1'&&sol[i+1][j]==-1)
                markIslands(grid,sol,islands,i+1,j);
        }
        if(inMat(grid,i,j+1)){
            if(grid[i][j+1]=='1'&&sol[i][j+1]==-1)
                markIslands(grid,sol,islands,i,j+1);
        }
        if(inMat(grid,i-1,j)){
            if(grid[i-1][j]=='1'&&sol[i-1][j]==-1)
                markIslands(grid,sol,islands,i-1,j);
        }
        if(inMat(grid,i,j-1)){
            if(grid[i][j-1]=='1'&&sol[i][j-1]==-1)
                markIslands(grid,sol,islands,i,j-1);
        }
    }

    bool inMat(vector<vector<char>>& grid, int i , int j){
        if((i>=0&&i<grid.size())&&(j>=0&&j<grid[0].size()))
            return true;
        else
            return false;
    }
};
