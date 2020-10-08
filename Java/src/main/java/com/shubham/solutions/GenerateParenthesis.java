package com.shubham.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {
	public static List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<>();
		StringBuilder currSeq=new StringBuilder();
		generateParenthesisUtils(n,0,0,0,ans,currSeq);
		return ans;
    }
	
	public static void generateParenthesisUtils(int n,int openCount, int closeCount, int stackCount,List<String> ans, StringBuilder currSeq) {
		
	    if(openCount==n&&closeCount==n&&stackCount==0) {
	    	ans.add(new String(currSeq));
	    	return;
	    }
	    
	    if(openCount<n) {
	    	stackCount++;
	    	openCount++;
	    	currSeq.append("(");
	    	generateParenthesisUtils(n,openCount,closeCount,stackCount,ans,currSeq);
	    	stackCount--;
	    	openCount--;
	    	currSeq.deleteCharAt(currSeq.length()-1);
	    }
	    if(stackCount>0) {
	    	stackCount--;
	    	closeCount++;
	    	currSeq.append(")");
	    	generateParenthesisUtils(n,openCount,closeCount,stackCount,ans,currSeq);
	    	currSeq.deleteCharAt(currSeq.length()-1);
	    }
	    
    }
	
	public static void main(String[] args) {
		int n=3;
		System.out.println(generateParenthesis(n));
	}
}
