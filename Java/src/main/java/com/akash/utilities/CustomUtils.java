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
		} catch (IOException e) {
		}
		return intArr;
	}
	public static int[] convertToInteger(String[] strArr) {
		int[] intArray = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
		/*
		 * Arrays.stream(strArr).mapToInt(a -> { return Integer.parseInt(a);
		 * }).toArray();
		 */
		return intArray;
	} 
	
}
