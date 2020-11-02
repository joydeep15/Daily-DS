#include<bits/stdc++.h>

using namespace std;

TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int,int> m;
        for(int i=0;i<inorder.size();i++)
            m[inorder[i]]=i;
        return buildTreeUtils(preorder,m,0,inorder.size()-1,0);
    }

    TreeNode* buildTreeUtils(vector<int> preorder, unordered_map<int,int> &m,int i, int j, int preIndex) {


        //static int preIndex=0;

        cout<<i<<" "<<j<<" "<<preIndex;

        if(i>j){
            return NULL;
        }

        int curr=preorder[preIndex];
        TreeNode *root=new TreeNode(curr);
        if(i==j)
            return root;

        int currPos=m[curr];
        root->left=buildTreeUtils(preorder,m,i,currPos-1,preIndex+1);
        root->right=buildTreeUtils(preorder,m,currPos+1,j,preIndex+currPos-i+1);

        return root;
    }
