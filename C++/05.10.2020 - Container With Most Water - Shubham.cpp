#include<bits/stdc++.h>

using namespace std;

int maxWater(vector<int> v){

    int i=0,j=v.size()-1,ans=0,curr;
    while(i<j){
        curr=min(v[i],v[j])*(j-i);
        if(curr>ans)
            ans=curr;
        (v[i]<v[j])?i++:j--;
    }
    return ans;
}

int main(){

    vector<int> v;
    v.push_back(1);
    v.push_back(2);
    v.push_back(1);
    printf("%d\n",maxWater(v));
    return 0;
}

/*
v.push_back(1);
    v.push_back(8);
    v.push_back(6);
    v.push_back(2);
    v.push_back(5);
    v.push_back(4);
    v.push_back(8);
    v.push_back(3);
    v.push_back(7);
*/

/*
    v.push_back(1);
    v.push_back(1);
*/

/*
    v.push_back(4);
    v.push_back(3);
    v.push_back(2);
    v.push_back(1);
    v.push_back(4);
*/

/*
    v.push_back(1);
    v.push_back(2);
    v.push_back(1);
*/
