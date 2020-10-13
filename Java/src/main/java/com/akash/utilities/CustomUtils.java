package com.akash.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CustomUtils {
	public static BufferedReader getBufferedReader() {
		return new BufferedReader(new InputStreamReader(System.in));
	}
	public static int[] readArrayInput(BufferedReader br) {
		int[] intArr = {};
		try {
			String inp = br.readLine();
			String[] inpArr = inp.split(" ");
			intArr = convertToInteger(inpArr);
		} catch (IOException ignored) {
		}
		return intArr;
	}
	public static int[] convertToInteger(String[] strArr) {
		/*
		 * Arrays.stream(strArr).mapToInt(a -> { return Integer.parseInt(a);
		 * }).toArray();
		 */
		return Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
	}
	public static void print2DArray(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void sort2DArray(int[][] arr, int index) {
//		Arrays.sort(arr, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[index]-o2[index];
//			}
//		});
		Arrays.sort(arr, (a,b)-> Integer.compare(a[index], b[index]));
	}
	
}
