#include<bits/stdc++.h>

using namespace std;

bool findEmptyCell(vector<vector<char>> board,int &i,int &j){
    for(i=0;i<9;i++)
        for(j=0;j<9;j++)
            if(board[i][j]=='.')
                return true;
    printf("Hi\n");
    return false;
}

int getBoxNumber(int i, int j){
    return 3*(i/3) +j/3;
}

bool isSafe(vector<vector<char>> board,int i,int j, int num,
    map<int,set<char>> rows,
     map<int,set<char>> cols,
      map<int,set<char>> boxes){
    char ch=num+'0';
    int boxN=getBoxNumber(i,j);
    return board[i][j]=='.'&&
    rows[i].find(ch)==rows[i].end() &&
    cols[j].find(ch)==cols[j].end() &&
    boxes[boxN].find(ch)==boxes[boxN].end();
}

/*
bool isColSatisfiedAndIsRowSatisfied(vector<vector<char>> board,int i,int j,char ch){
    //printf("Okay till isColSatisfied\n");
    for(int a=0;a<9;a++)
        if(board[a][j]==ch||board[i][a]==ch)
            return false;
    return true;
}

bool isColSatisfied(vector<vector<char>> board,int j,char ch){
    //printf("Okay till isColSatisfied\n");
    for(int a=0;a<9;a++)
        if(board[a][j]==ch)
            return false;
    return true;
}

bool isRowSatisfied(vector<vector<char>> board,int i,char ch){
    //printf("Okay till isRowSatisfied\n");
    for(int a=0;a<9;a++)
        if(board[i][a]==ch)
            return false;
    return true;
}

bool isBoxSatisfied(vector<vector<char>> board,int i, int j, char ch){
    //printf("Okay till isBoxSatisfied\n");
    for(int a=0;a<3;a++)
        for(int b=0;b<3;b++)
            if(board[i+a][j+b]==ch)
                return false;
    return true;
}

bool isSafe(vector<vector<char>> board,int i,int j, int num){
    //printf("Okay till isSafe : %d %d %d\n",i,j,num);
    char ch=num+'0';
    // return board[i][j]=='.'&&
    //    isColSatisfied(board,j,ch)&&isRowSatisfied(board,i,ch)
    //     &&isBoxSatisfied(board,i-i%3,j-j%3,ch);
        return board[i][j]=='.'&&
           isColSatisfiedAndIsRowSatisfied(board,i,j,ch)&&
            isBoxSatisfied(board,i-i%3,j-j%3,ch);
    }
*/

bool solveSudokuUtils(vector<vector<char>>& board,
    map<int,set<char>> &rows,
     map<int,set<char>> &cols,
      map<int,set<char>> &boxes){
    int i,j;
    bool temp;
    if(!findEmptyCell(board,i,j))
        return true;
    for(int num=1;num<=9;num++){
        temp=isSafe(board,i,j,num,rows,cols,boxes);
        //temp=isSafe(board,i,j,num);
        if(temp){
            rows[i].insert(num+'0');
            cols[j].insert(num+'0');
            boxes[getBoxNumber(i,j)].insert(num+'0');
            board[i][j]=num+'0';
            if(solveSudokuUtils(board,rows,cols,boxes))
                return true;
            board[i][j]='.';
            rows[i].erase(num+'0');
            cols[j].erase(num+'0');
            boxes[getBoxNumber(i,j)].erase(num+'0');
        }
    }
    return false;
}

void printSudoku(vector<vector<char>> board){
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++)
            printf("%c ",board[i][j]);
        printf("\n");
    }
}

void solveSudoku(vector<vector<char>>& board) {
    map<int,set<char>> rows;
    map<int,set<char>> cols;
    map<int,set<char>> boxes;
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            if(board[i][j]!='.'){
                rows[i].insert(board[i][j]);
                cols[j].insert(board[i][j]);
                boxes[getBoxNumber(i,j)].insert(board[i][j]);
            }
        }
    }
    bool isSolvable=solveSudokuUtils(board,rows,cols,boxes);
    printSudoku(board);
}

int main(){
    vector<vector<char>> board=
    {{'5','3','.','.','7','.','.','.','.'},
    {'6','.','.','1','9','5','.','.','.'},
    {'.','9','8','.','.','.','.','6','.'},
    {'8','.','.','.','6','.','.','.','3'},
    {'4','.','.','8','.','3','.','.','1'},
    {'7','.','.','.','2','.','.','.','6'},
    {'.','6','.','.','.','.','2','8','.'},
    {'.','.','.','4','1','9','.','.','5'},
    {'.','.','.','.','8','.','.','7','9'}};
    solveSudoku(board);
    return 0;
}
