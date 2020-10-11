#include<bits/stdc++.h>

using namespace std;

bool comparator(vector<int> balloon1,vector<int> balloon2){
        if (balloon1[0]!=balloon2[0])
            return balloon1[0]<balloon2[0];
        else
            return balloon1[1]<balloon2[1];
    }

int findMinArrowShots(vector<vector<int>>& points) {
        int ans=0;
        sort(points.begin(),points.end(),comparator);
        int i=0,j,currEnd;
        while(i<points.size()){
            ans++;
            currEnd=points[i][1];
            i++;
            //j=i+1;
            while(i<points.size()&&points[i][0]<=currEnd){
                if(currEnd>points[i][1])
                    currEnd=points[i][1];
                i++;
            }
        }
        return ans;
    }

int main(){
    vector<vector<int>> points{{10,16},{2,8},{1,6},{7,12}};
    printf("%d",findMinArrowShots(points));
    return 0;
}
