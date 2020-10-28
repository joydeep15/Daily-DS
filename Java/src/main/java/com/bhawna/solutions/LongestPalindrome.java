package com.bhawna.solutions;

class LongestPalindrome {
    int maxLen=0;
    int start=0;
    int end=0;
    public String longestPalindrome(String s) {
        
        int len=s.length();
        for(int i=0;i<len;i++){
           extendPalindrome(s,i,i);
           extendPalindrome(s,i,i+1);
        }
        return s.substring(start,end+1);
    }
    
    public void extendPalindrome(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        if(maxLen<j-i+1){
            start=i+1;
            end=j-1;
            maxLen=j-i+1;
        }
    }
}
