package com.shubham.solutions;

import java.util.Stack;

public class NextLargerElement {
	public static int[] nextGreaterElements(int[] nums) {
		int resp[]=new int[nums.length];
		for(int i=0;i<nums.length;i++) {
        	resp[i]=-1;
        }
		int indexOfLargestElement=nums.length-1,i=nums.length-2;
		while(i>=0) {
			if(nums[i]>=nums[indexOfLargestElement])
				indexOfLargestElement=i;
			i--;
		}
        Stack<Integer> s = new Stack<>();
		s.push(indexOfLargestElement);
		i=indexOfLargestElement-1;
		if(i<0)
			i=nums.length-1;
        while(i!=indexOfLargestElement) {
			
            while(s.size()!=0&&nums[i]>=nums[s.peek()])
				s.pop();
			if(s.size()!=0&&nums[i]<nums[s.peek()]) {
				resp[i]=nums[s.peek()];
				s.push(i);
			}
			else{
                resp[i]=-1;
			}
            if(resp[i]==-1&&nums[i]<nums[indexOfLargestElement]&&s.size()==0){
                resp[i]=nums[indexOfLargestElement];
                s.push(i);
            }
			i--;
			if(i<0)
				i=nums.length-1;
		}
        return resp;
    
    }
	public static void main(String[] args) {
		//int[] nums={1,2,1};
		int[] nums={1,2,2,2,2,2,2,2,2,2,2,2};
		int[] resp = nextGreaterElements(nums);
		for(int i=0;i<nums.length;i++)
			System.out.print(resp[i]+" ");
	}
}
