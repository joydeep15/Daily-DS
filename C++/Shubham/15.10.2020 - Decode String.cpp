#include<bits/stdc++.h>

using namespace std;

int decodeString(string s){
    int ans[s.length()+1];
    ans[0]=1;
    ans[1]=1;
    if(s[0]=='0')
        return 0;
    for(int i=2;i<s.length()+1;i++){
        ans[i]=0;
        if(s[i-1]>'0')
            ans[i]=ans[i-1];
        if(s[i-2]=='1'||(s[i-2]=='2'&&s[i-1]<='6'))
            ans[i]+=ans[i-2];
    }

    return ans[s.length()];
}

int main(){
    string s="1234";
    printf("%d",decodeString(s));
    return 0;
}
