package com.akash.solutions;

import java.util.Arrays;

class DecodeString {
    int[] dpState = new int[101];
    public int numDecodings(String str) {
        Arrays.fill(dpState, -1);
        return ways(str, str.length()-1);
    }
    /*
    Recursive Intuition:
    Element of choice: Take individually or pair up
    Start from the last index
    ways(i) =
    Case 1: individual
     0*ways(i-1) if str[i] =='0' else
     1*ways(i-1)
         ( + )
     Case 2: Pair up
     0*ways(i-2) if str[i-1] == '0' or str[i-1] >'2' else
     1*ways(i-2) if str[i-1] == '1' or (str[i-1] == '2' and str[i] <= '6')

     */
    public int ways(String str, int index){
        if(index < 0) return 1;
        if(index == 0 ){
            if(str.charAt(index) == '0') return 0;
            else return 1;
        }
        if(dpState[index] != -1) return dpState[index];
        //Element of choice take individually or pair up
        int individualCount = 0;
        int pairCount = 0;
        char cur = str.charAt(index);
        char prev = str.charAt(index-1);
        if(cur == '0'){
            individualCount = 0;
        } else {
            individualCount = 1*ways(str, index-1);
        }
        if(prev == '0' || prev > '2'){
            pairCount = 0;
        } else if(prev == '1' || (prev == '2' && cur <= '6')){
            pairCount = 1*ways(str, index-2);
        }
        return dpState[index] = individualCount + pairCount;
    }
}