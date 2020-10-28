package com.shubham.solutions;

import java.util.Arrays;
import java.util.List;

import com.shubham.utils.tree.TreeNode;
public class FindPeakElement {
	
	public static int findPeakElement(int[] nums) {
        int l=0,h=nums.length-1,mid = 0;
        while(l<h) {	
        	mid=(h+l)/2;
        	if(nums[mid]>nums[mid+1])
        		h=mid;
        	else
        		l=mid+1;
        }
        return mid;
    }
	
	
	public static void main(String[] args) {
		int[] nums= {1,2,3,1};
		System.out.println(findPeakElement(nums));
	}
}
