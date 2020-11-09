package com.shubham.solutions;

import java.util.Arrays;
import java.util.List;

import com.shubham.utils.tree.TreeNode;
public class TicTacToe {
	
	public static boolean hasPlayerWon(String[] board, char ch){
        String temp="";
        temp+=ch;
        temp+=ch;
        temp+=ch;
		if(board[0].equals(temp)||board[1].equals(temp)||board[2].equals(temp)||
				(board[0].charAt(0)==ch&&board[1].charAt(0)==ch&&board[2].charAt(0)==ch)||
				(board[0].charAt(1)==ch&&board[1].charAt(1)==ch&&board[2].charAt(1)==ch)||
				(board[0].charAt(2)==ch&&board[1].charAt(2)==ch&&board[2].charAt(2)==ch)||
					(board[0].charAt(0)==ch&&board[1].charAt(1)==ch&&board[2].charAt(2)==ch)||
					(board[0].charAt(2)==ch&&board[1].charAt(1)==ch&&board[2].charAt(0)==ch))
			return true;
		return false;
    }
    
    public static boolean validTicTacToe(String[] board) {
        int xcount=0,ocount=0;
    	for(int i=0;i<3;i++) {
        	for(int j=0;j<3;j++) {
        		if(board[i].charAt(j)=='X')
        			xcount++;
        		else if(board[i].charAt(j)=='O')
        			ocount++;
        	}
        }
    	if(xcount-ocount>1||xcount-ocount<0)
    		return false;
    	
        boolean xwin=hasPlayerWon(board, 'X');
        if(xwin==true)
            return xcount-ocount==1;
        boolean owin=hasPlayerWon(board, 'O');
        if(owin==true)
            return xcount-ocount==0;
        
        return true;
        //return !(xwin&&owin);
    }
	
	
	public static void main(String[] args) {
		String[] board = {"O  ", "   ", "   "};
		System.out.println(validTicTacToe(board));
	}
}
