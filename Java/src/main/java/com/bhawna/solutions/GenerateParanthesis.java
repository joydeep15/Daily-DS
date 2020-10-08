package com.bhawna.solutions;

import java.util.ArrayList;
import java.util.List;

class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        generateParanthesisUtil(n,ans,"",0,0);
        return ans;
    }
    
    void generateParanthesisUtil(int n,List<String> ans, String subans,int close,int open){
        if(subans.length()==2*n){
            ans.add(subans);
            return;
        }
        if(close<open){
            generateParanthesisUtil(n,ans,subans+")",close+1,open);
        }
        if(open<n){
            generateParanthesisUtil(n,ans,subans+"(",close,open+1);
        }
    }
}
