package com.shubham.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.shubham.utils.tree.TreeNode;
public class AllSubsets {
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans= new ArrayList();
		int n=nums.length;
		for(int i=(int) Math.pow(2, n);i<(int) Math.pow(2, n+1);i++) {
			String bitmask=Integer.toBinaryString(i).substring(1);
			List<Integer> temp = new ArrayList();
			for(int j=0;j<n;j++) 
				if(bitmask.charAt(j)=='1')
					temp.add(nums[j]);
			ans.add(temp);
		}
		return ans;
    }
	
	
	public static void main(String[] args) {
		int[] nums= {1,2,3};
		System.out.println(subsets(nums));
	}
}
