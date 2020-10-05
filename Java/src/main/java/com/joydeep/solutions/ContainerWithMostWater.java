package com.joydeep.solutions;

public class ContainerWithMostWater {

//    https://leetcode.com/problems/container-with-most-water/
    public int maxArea(int[] height) {

        if(height.length < 1)
            return -1;

        int maxWater = -1;
        int i = 0;
        int j = height.length -1;

        while(i < j){

            //calculate water between h[i] and h[j]
            int containerLength = Math.min(height[i], height[j]);
            int containerWidth = j - i;
            maxWater = Math.max(maxWater, containerLength * containerWidth );

            //choose to move left or right

            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }

        return maxWater;

    }
}
