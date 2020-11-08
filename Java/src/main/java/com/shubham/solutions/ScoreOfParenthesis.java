package com.shubham.solutions;

import java.util.Arrays;
import java.util.List;

import com.shubham.utils.tree.TreeNode;
public class ScoreOfParenthesis {
	
	public static int scoreOfParentheses(String S) {
        int ans=0;
        int bal=0;
        for(int i=0;i<S.length();i++) {
        	if(S.charAt(i)=='(')
        		bal++;
        	else {
        		bal--;
        		if(S.charAt(i-1)=='(')
        			ans+=1<<bal;
        	}
        }
        return ans;
    }	
	
	public static void main(String[] args) {
		System.out.println(scoreOfParentheses("(()(()))"));
	}
}
