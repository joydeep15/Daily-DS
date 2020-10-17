package com.bhawna.solutions;

class DecodeWays {
    public int numDecodings(String s) {
        int len=s.length();
        int ways[]=new int[len+1];
        if(len<1 || s.charAt(0)=='0')
            return 0;
        ways[0]=1;
        ways[1]=1;
        int curr,mergeEnd;
        for(int i=1;i<len;i++){
            curr=s.charAt(i)-'0';
            int merged=Integer.parseInt(s.substring(i-1,i+1));
            //there is a 0 and by merging it prevs, it is neither 10 nor 20 , hence invalid  encoding
            if(curr==0 && merged!=10 && merged!=20)
                 return 0; 
            //if curr=0 and merged=10 or 20
            else if(curr==0)
                ways[i+1]=ways[i-1];
            else if(merged>26 || merged<11)
                 ways[i+1]=ways[i];
            else 
                ways[i+1]=ways[i]+ways[i-1];
        }
        return ways[len];
    }
}
