package com.shubham.solutions;

import java.util.Arrays;
import java.util.List;

import com.shubham.utils.tree.TreeNode;
public class UniquePaths {
	
	static int uniquePaths(int m, int n) {
		int[][] ans=new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0||j==0)
					ans[i][j]=1;
				else
					ans[i][j]=ans[i-1][j]+ans[i][j-1];
			}
		}
		return ans[m-1][n-1];
	}
	
	
	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 4));
	}
}
