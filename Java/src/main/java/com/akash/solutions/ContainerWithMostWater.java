package com.akash.solutions;

import java.io.BufferedReader;

import com.akash.utilities.CustomUtils;


/**
 * Problem Link: https://leetcode.com/problems/container-with-most-water/#
 * @author goodknight
 *
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		BufferedReader br = CustomUtils.getBufferedReader();
		int[] height = CustomUtils.readArrayInput(br);
		System.out.println(maxArea(height));
	}

	/*
	 * intuition: 
	 * start with max width container using two pointers
	 * move the pointer from the side which has the minimum height as minimum height is 
	 * what will give the max area for that width of container
	 *
	 */
	public static int maxArea(int[] height) {
		int i = 0, j = height.length - 1;
		int maxArea = 0;
		while (i < j) {
			// move the pointer for the minimum height of line
			if (height[i] < height[j]) {
				maxArea = Math.max(maxArea,(j-i)*height[i]);
				i++;
			} else {
				maxArea = Math.max(maxArea,(j-i)*height[j]);
				j--;
			}
		}
		return maxArea;
	}


}
