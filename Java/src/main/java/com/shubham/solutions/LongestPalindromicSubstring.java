package com.shubham.solutions;

public class LongestPalindromicSubstring {
	
	public static String longestPalindrome(String s) {
        String ans = null;
		int l,maxlen=0;
		for(int i=0;i<s.length();i++) {
        	l=Math.max(longestPalindromeUtils(s,i,i), longestPalindromeUtils(s,i,i+1));
        	if(l>maxlen) {
        		maxlen=l;
        		ans=s.substring(i-(l-1)/2, i+l/2 + 1);
        		System.out.println("Updating..");
        		System.out.println(maxlen);
        		System.out.println(ans);
        	}
        }
		return ans;
    }
	
	public static int longestPalindromeUtils(String s, int s1,int s2) {
		while(s1>=0&&s2<s.length()&&s.charAt(s1)==s.charAt(s2)) {
			s1--;
			s2++;
		}
		return s2-s1-1;
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("abbca"));
	}
}
