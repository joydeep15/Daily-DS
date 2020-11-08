class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> ans;
        set<multiset<int>> s;
        int k=0;

        unordered_map<int,int> m;
        for(int i=0;i<nums.size();i++)
            m[nums[i]]++;
        unordered_map<int,int>::iterator it1,it2;
        int val1,val2,val3;
        for(it1=m.begin();it1!=m.end();it1++){
            val1=it1->first;
            for(it2=m.begin();it2!=m.end();it2++){
                val2=it2->first;
                if(m.find(k-val1-val2)!=m.end()){
                    val3=m.find(k-val1-val2)->first;
                    if(val1==val2&&val1==val3){
                        if(m[val1]>=3){
                            vector<int> temp;
                            temp.push_back(val1);
                            temp.push_back(val1);
                            temp.push_back(val1);
                            multiset<int> tempset;
                            tempset.insert(val1);
                            tempset.insert(val1);
                            tempset.insert(val1);
                            if(s.find(tempset)==s.end()){
                                ans.push_back(temp);
                                s.insert(tempset);
                            }
                        }
                    }
                    else if(val1==val2){
                        if(m[val1]>=2){
                            vector<int> temp;
                            temp.push_back(val1);
                            temp.push_back(val1);
                            temp.push_back(val3);
                            multiset<int> tempset;
                            tempset.insert(val1);
                            tempset.insert(val1);
                            tempset.insert(val3);
                            if(s.find(tempset)==s.end()){
                                ans.push_back(temp);
                                s.insert(tempset);
                            }
                        }
                    }
                    else if(val1==val3){
                        if(m[val1]>=2){
                            vector<int> temp;
                            temp.push_back(val1);
                            temp.push_back(val1);
                            temp.push_back(val2);
                            multiset<int> tempset;
                            tempset.insert(val1);
                            tempset.insert(val1);
                            tempset.insert(val2);
                            if(s.find(tempset)==s.end()){
                                ans.push_back(temp);
                                s.insert(tempset);
                            }
                        }
                    }
                    else if(val3==val2){
                        if(m[val3]>=2){
                            vector<int> temp;
                            temp.push_back(val2);
                            temp.push_back(val2);
                            temp.push_back(val1);
                            multiset<int> tempset;
                            tempset.insert(val2);
                            tempset.insert(val2);
                            tempset.insert(val1);
                            if(s.find(tempset)==s.end()){
                                ans.push_back(temp);
                                s.insert(tempset);
                            }
                        }
                    }
                    else{
                        vector<int> temp;
                        temp.push_back(val1);
                        temp.push_back(val2);
                        temp.push_back(val3);
                        multiset<int> tempset;
                        tempset.insert(val1);
                        tempset.insert(val2);
                        tempset.insert(val3);
                        if(s.find(tempset)==s.end()){
                            ans.push_back(temp);
                            s.insert(tempset);
                        }
                    }

                }
            }
        }
        return ans;
    }
};
