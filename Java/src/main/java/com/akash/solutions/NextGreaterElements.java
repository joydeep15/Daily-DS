package com.akash.solutions;

public class NextGreaterElements {
//    int[] dpstate
    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i] = getNextGreater(nums,i,i);
        }
        return res;
    }
    public static int getNextGreater(int[] nums, int index, int originalIndex){
        if(index == nums.length-1){
            return getNextGreater(nums, 0, nums[originalIndex]);
        }
        if(index+1 == originalIndex) return -1;
        if(nums[originalIndex] < nums[index+1]){
            return nums[index+1];
        }
        else{
            int next = getNextGreater(nums, index+1, nums[originalIndex]);
            if(nums[originalIndex] < next){
                return next;
            }
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int[] res = nextGreaterElements(nums);
        for(int x: res){
            System.out.print(x+ " ");
        }

    }
}
