/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    string findDuplicateSubtreesUtils(TreeNode* root, map<string,vector<TreeNode* > > &s){
        if(root==NULL)
            return "";
        string curr=to_string(root->val)+"("+findDuplicateSubtreesUtils(root->left, s)+")"+
            "("+findDuplicateSubtreesUtils(root->right, s)+")";
        s[curr].push_back(root);
        return curr;
    }

    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        vector<TreeNode*> ans;
        map<string,vector<TreeNode* > > s;
        findDuplicateSubtreesUtils(root, s);
        map<string,vector<TreeNode* >>::iterator it;
        for(it=s.begin();it!=s.end();it++)
            if(it->second.size()>1)
                ans.push_back(it->second[0]);
        return ans;
    }
};
