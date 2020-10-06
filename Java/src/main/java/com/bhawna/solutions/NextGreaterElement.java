package com.bhawna.solutions;

import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int next=0;
        int n=nums.length;
        int[] ans=new int[n];
        //Optimized solution
        Stack<Integer> largerIndex=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
        //Keep popping till stack is empty or we find a greater element(from stack top) than current elt
            while(!largerIndex.isEmpty() && nums[largerIndex.peek()]<=nums[i%n]){
                largerIndex.pop();
            }
            //If stack is still empty,couldnt find larger elt from stack, update ans with -1 
            //else whatever stack top gave as larger elt
            ans[i%n]=(largerIndex.isEmpty())?-1:nums[largerIndex.peek()];
            largerIndex.push(i%n);
        }
        
        //My initial approach
     /*   int cycle;
        for(int i=0;i<n;i++){
            next=(i+1)%n;
            cycle=0;
            //Keep going to next untill we find a greate elt than nums[i]
            while(nums[next]<=nums[i]){
                next=(next+1)%n;
                cycle++;
                //if one cycle completed and still couldnt find a greater number
                if(cycle-i>=n && nums[next]<=nums[i]){
                    ans[i]=-1;
                    break;
                }
                else if(nums[next]>nums[i]){
                    break;
                }
            }
            //If not updated yet i.e. else condition
            if(ans[i]!=-1)
                ans[i]=nums[next];
        }*/
        return ans;
    }
    
}
