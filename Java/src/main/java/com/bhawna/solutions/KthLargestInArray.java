package com.bhawna.solutions;

class KthLargestInArray {
    void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    
    int partition(int[] a,int left, int right){
        int mid=left+(right-left)/2;
        int pivot=a[mid];
        swap(a,mid,right);
        int i=left-1;
        for(int j=left;j<right;j++){
            if(a[j]>pivot){
              i++;
              swap(a,i,j);
            }
        }
        swap(a,i+1,right);
        return i+1;
    }
    
    public int findKthLargest(int[] nums, int k) {
        int left=0;
        int right=nums.length-1;
        int pivotLoc;
        while(left<right){
            pivotLoc=partition(nums,left,right);
            if(k==pivotLoc+1)
                return nums[pivotLoc];
            else if(k<pivotLoc+1)
                right=pivotLoc-1;
            else
                left=pivotLoc+1;
        }
        return nums[left];    
  }
}
