package com.shubham.solutions;

import java.util.Arrays;

public class FirstAndLastPos {
	public static int[] falp(int[] nums,int target) {
		int[] ans= {-1,-1};
		if(nums.length==0)
			return ans;
		int first=-1,last=-1;
		if(nums[0]==target)
			first=0;
		if(nums[nums.length-1]==target)
			last=nums.length-1;
		int l=0,h=nums.length-1,mid;
		if(first==-1) {
			while(l<=h) {
				mid=h-(h-l)/2;
				if(nums[mid]==target&&nums[mid-1]!=target) {
					first=mid;
					break;
				}
				else if(nums[mid]>=target)
					h=mid-1;
				else
					l=mid+1;
			}
		}
		l=0;
		h=nums.length-1;
		if(last==-1) {
			while(l<=h) {
				mid=h-(h-l)/2;
				if(nums[mid]==target&&nums[mid+1]!=target) {
					last=mid;
					break;
				}
				else if(nums[mid]<=target)
					l=mid+1;
				else
					h=mid-1;
			}
		}
		ans[0]=first;
		ans[1]=last;
		return ans;
    }
	public static void main(String[] args) {
		int[] nums={5,7,7,8,8,10};
		int target=7;
		System.out.println(falp(nums,target));
	}
}
