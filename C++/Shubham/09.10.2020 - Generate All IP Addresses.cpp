#include<bits/stdc++.h>

using namespace std;

vector<string> restoreIpAddresses(string s) {
        vector<string> ans;
        string str;
        for(int i=0;i<=2&&i<s.length();i++){
            for(int j=i+1;j<=i+3&&j<s.length();j++){
                for(int k=j+1;k<=j+3&&k<s.length();k++){
                    printf("%d %d %d\n",i,j,k);
                    str="";
                    if(isValid(s,i,j,k,str)){
                        printf("Hi\n");
                        ans.push_back(str);
                    }
                }
            }
        }
        return ans;
    }

    bool isValid(string s,int d1,int d2,int d3,string &str){
        if(!(d1<=2&&d1>=0&&d2-d1<=3&&d2-d1>=1&&d3-d2<=3&&d3-d2>=1&&s.length()-d3-1<=3&&s.length()-d3-1>=1))
            return false;
        //string sub="";
        if(isSubSectionValid(s,0,d1,str))
            str.append(".");
        else
            return false;
        if(isSubSectionValid(s,d1+1,d2,str))
            str.append(".");
        else
            return false;
        if(isSubSectionValid(s,d2+1,d3,str))
            str.append(".");
        else
            return false;
        if(!(isSubSectionValid(s,d3+1,s.length()-1,str)))
            return false;
        return true;
    }

    bool isSubSectionValid(string s,int l,int h,string &str){
        if(h-l==0){
            str+=s[l];
            return true;
        }
        else if(h-l==1){
            if(s[l]=='0')
                return false;
            else{
                str+=s[l];
                str+=s[h];
                return true;
            }
        }
        else if(h-l==2){
            if(s[l]=='0'||(s[l]>='3'&&s[l]<='9')
               ||(s[l]=='2'&&s[l+1]>='6'&&s[l+1]<='9')
               ||(s[l]=='2'&&s[l+1]=='5'&&s[h]>='6'&&s[h]<='9'))
                return false;
            else{
                str+=s[l];
                str+=s[l+1];
                str+=s[h];
                return true;
            }
        }
        return true;
    }

int main(){

    string s="25525511135";
    vector<string> ans=restoreIpAddresses(s);
    for(int i=0;i<ans.size();i++)
        printf("%s\n",ans[i]);
    return 0;
}
