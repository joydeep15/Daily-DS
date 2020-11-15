package com.bhawna.solutions;

class ValidTicTacToe {
    public boolean validTicTacToe(String[] board) {
        int[] rowSum=new int[3];
        int[] colSum=new int[3];
        int diag=0;
        int antidiag=0;
        boolean xwins=false;
        boolean owins=false;
        int extraXTurns=0;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)=='X'){
                    extraXTurns++;
                    rowSum[i]++;
                    colSum[j]++;
                    if(i==j)
                        diag++;
                    if(i+j==2)
                        antidiag++;
                }
                else if(board[i].charAt(j)=='O'){
                    extraXTurns--;
                    rowSum[i]--;
                    colSum[j]--;
                    if(i==j)
                        diag--;
                    if(i+j==2)
                        antidiag--;
                }
            }
         //   System.out.println("rowSum: "+Arrays.toString(rowSum)+" colSum: "+Arrays.toString(colSum)+" xturns:"+extraXTurns);
        }
        
        if(rowSum[0]==3||rowSum[1]==3||rowSum[2]==3||colSum[0]==3||colSum[1]==3||colSum[2]==3||diag==3||antidiag==3)
            xwins=true;
        else if(rowSum[0]==-3||rowSum[1]==-3||rowSum[2]==-3||colSum[0]==-3||colSum[1]==-3||colSum[2]==-3||diag==-3||antidiag==-3)
            owins=true;
       // System.out.println(xwins+" "+owins+" "+extraXTurns);
        if(xwins && owins)
            return false;
        if(xwins && extraXTurns==0 || owins && extraXTurns==1)
            return false;
        return (extraXTurns==0)||(extraXTurns==1);
    }
}
