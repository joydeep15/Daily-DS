package com.akash.solutions;

import com.akash.utilities.CustomUtils;

/**
 * @author goodknight
 * Ques Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class MinArrowToBurstBalloons {

	public static int findMin(int[][] arr) {
		if(arr.length == 0) return 0;
		int count = 1;
		int minEnd = arr[0][1];
		for(int i=1;i<arr.length;i++) {
			int start = arr[i][0];
			int end = arr[i][1];
			/*
			 * 1. If start of current point is less than minEnd till previous point, 
			 * balloon will fit into. Hence just update minEnd
			 * 2. Else update the count and minEnd
			 */
			if(start > minEnd) {
				count++;
				minEnd = end;
			} else {
				minEnd = Math.min(minEnd, end);
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int[][] inp = {{10,16},{2,8},{1,6},{7,12}};
//		int inp[][] = {{1,2},{3,4},{5,6},{7,8}};
		CustomUtils.sort2DArray(inp, 0);
//		CustomUtils.print2DArray(inp);
		System.out.println(findMin(inp));
	}

}
