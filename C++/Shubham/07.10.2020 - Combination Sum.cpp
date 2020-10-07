#include<bits/stsc++.h>

using namespace std;

vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(),candidates.end());
        vector<vector<int> > ans;
        vector<int> currCombo;
        combinationSumUtils(candidates,target,ans,currCombo,0);
        return ans;
    }

void combinationSumUtils(vector<int>& candidates, int target,
                             vector<vector<int>> &ans, vector<int> currCombo, int currIndex){
    int i=currIndex;
    while(i<candidates.size()){
        if(candidates[i]==target){
            currCombo.push_back(candidates[i]);
            ans.push_back(currCombo);
            break;
        }
        else if(candidates[i]<target){
            currCombo.push_back(candidates[i]);
            combinationSumUtils(candidates,target-candidates[i],ans,currCombo,currIndex);
            currIndex++;
            currCombo.pop_back();
        }
        i++;
    }
}

int main(){

    vector<int> candidates;
    candidates.push_back(2);
    candidates.push_back(3);
    candidates.push_back(6);
    candidates.push_back(7);
    int target=7;
    vector<vector<int>> ans = combinationSum(candidates,target);
    for(int i=0;i<ans.size();i++){
        for(int j=0;j<ans[0].size();j++)
            printf("%d ",ans[i][j]);
        printf("\n");
    }
    return 0;
}
