package com.bhawna.solutions;

class FirstAndLastPos {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int mid;
        int start=-1;
        int end=-1;
        if(start==-1){
            while(low<=high){
                mid=low+(high-low)/2;
                if(nums[mid]==target ){
                    //Keep updating high and start to find its leftmost occurence 
                    start=mid;
                    high=mid-1;
                }
                else if(nums[mid]<target)
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        low=start==-1?0:start;
        high=n-1;     
        if(end==-1){
            while(low<=high){
                mid=low+(high-low)/2;
                if(nums[mid]==target ){
                    //Keep updating low and end to find its rightmost occurence 
                    end=mid;
                    low=mid+1;
                }
                else if(nums[mid]<target)
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return new int[]{start,end};
    }
} 
