package com.joydeep.solutions;

import java.util.*;

public class Threesum {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for(int i=0; i < nums.length; i++){

            int j=i+1;
            int k=nums.length - 1;
            int target = -nums[i];
            while( j < k){

                if(j == i){
                    j++;
                    continue;
                }

                if(k == i){
                    k--;
                    continue;
                }

                if( nums[j] + nums[k] == target){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    Collections.sort(curr);
                    result.add(curr);
                    j++;
                    k--;
                }else if(nums[j] + nums[k] < target){
                    j++;
                }else{
                    k--;
                }


            }
        }

        return new ArrayList<>(result);

    }
}
