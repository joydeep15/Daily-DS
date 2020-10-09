package com.shubham.solutions;

import java.util.Arrays;

public class RemoveCoveredIntervals {
	public static int rci(int[][] intervals) {
		Arrays.sort(intervals,new java.util.Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
		   		if(a[0]!=b[0])
		   			return Integer.compare(a[0], b[0]);
		   		else
		   			return Integer.compare(b[1], a[1]);
	    	}
	    });
		int total=1,biggestEnding=intervals[0][1];
		System.out.println(intervals[0][0]+" "+intervals[0][1]);
		for(int i=1;i<intervals.length;i++) {
			if(intervals[i][1]>biggestEnding) {
				total++;
				System.out.println(intervals[i][0]+" "+intervals[i][1]);
				biggestEnding=intervals[i][1];
			}
		}
		return total;
    }
	public static void main(String[] args) {
		int[][] intervals={{1,4},{3,6},{2,8}};
		System.out.println(rci(intervals));
	}
}
