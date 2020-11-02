package com.shubham.solutions;

import java.util.Arrays;
import java.util.List;

import com.shubham.utils.tree.TreeNode;
public class FindMissingPositive {
		
	public static int firstMissingPositive(int[] nums) {
        Boolean[] b=new Boolean[nums.length+1];
        for(int i=0;i<=nums.length;i++)
        	b[i]=false;
        for(int i=0;i<nums.length;i++)
        	if(nums[i]>0&&nums[i]<nums.length)
        		b[nums[i]]=true;
        for(int i=1;i<=nums.length;i++)
        	if(!b[i])
        		return i;
        return nums.length+1;
    }
	
	
	public static void main(String[] args) {
		int[] nums= {1,2,0};
		System.out.println(firstMissingPositive(nums));
	}
}
