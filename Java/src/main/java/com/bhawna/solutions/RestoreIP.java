package com.bhawna.solutions;

import java.util.ArrayList;
import java.util.List;

class RestoreIP {
    
    boolean isValidSubIp(String subip){
        if((subip.charAt(0)=='0' && subip.length()>1) ||Integer.parseInt(subip)>255)
            return false;
        return true;
    }
    void getIpUtil(List<String> ans, List<String> subip,String input,int start){
        //subip: dot separated portions of an ip
        //If we got 4 such parts and have also reached end of given input string
        if(subip.size()==4 & start==input.length()){
            String curr_ip=String.join(".",subip);
            ans.add(curr_ip);
            return;
        }
        
        //To loop for subip size i.e. subip can have 1/2/3 digits
        for(int i=1;i<=4 && start+i<=input.length();i++){
            String potentialSubIp=input.substring(start,start+i);
            //Add it to subip list only if it is valid
            if(isValidSubIp(potentialSubIp)){
                subip.add(potentialSubIp);
                getIpUtil(ans,subip,input,start+i);
                subip.remove(subip.size()-1);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList<>();
        if(s.length()==0 || s.length()>12)
            return ans;
        getIpUtil(ans,new ArrayList<>(),s,0);
        return ans;
    }
}
