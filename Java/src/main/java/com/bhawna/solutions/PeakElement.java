package com.bhawna.solutions;

class PeakElement {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int mid;
        
        while(low<=high){
            mid=low+(high-low)/2;
            if(low==high)
                return mid;
            else if(nums[mid]>nums[mid+1])
                high=mid;
            else
                low=mid+1;
        }
        return -1;
    }
}
