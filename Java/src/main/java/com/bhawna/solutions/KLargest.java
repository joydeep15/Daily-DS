package com.bhawna.solutions;

import java.util.*; 

class KLargest {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
            if(pq.size()>k)
                pq.remove();
        }
        return pq.peek();
        
        //Or, can do by array sorting
       /* Arrays.sort(nums);
        int curr=1;
        
        for(int i=nums.length-1;i>=0;i--,curr++){
                if(curr==k)
                    return nums[i];
        }
        return -1;
        */
    }
}
