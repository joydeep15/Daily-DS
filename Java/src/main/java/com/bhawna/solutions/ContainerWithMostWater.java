package com.bhawna.solutions;

public class ContainerWithMostWater {
	    public int maxArea(int[] height) {
	        int n=height.length;
	        int maxSum=Integer.MIN_VALUE;
	        int low=0;
	        int high=n-1;
	        while(low<=high){
	            maxSum=Math.max(maxSum,(high-low)*Math.min(height[low],height[high]));
	            if(height[low]<height[high])
	                low++;
	            else
	                high--;
	        }
	        return maxSum;
	    }
}
