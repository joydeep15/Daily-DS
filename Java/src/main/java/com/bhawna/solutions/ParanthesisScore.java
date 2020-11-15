package com.bhawna.solutions;

class ParanthesisScore {
    public int scoreOfParentheses(String S) {
        int count=0;
        int ans=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){
                count++;
            }
            else{
                count--;
                if(S.charAt(i-1)=='(')
                    ans+=1<<count;
            }
        }
        return ans;
    }
}
