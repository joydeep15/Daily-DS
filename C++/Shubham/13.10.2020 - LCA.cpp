#include<bits/stdc++.h>

using namespace std;

typedef struct TreeNode{
    int val;
    TreeNode *left;
    TreeNode *right;
};

bool lcaUtils(TreeNode* root, TreeNode* p, TreeNode* q,TreeNode **ans){
    if(root==NULL)
        return false;
    bool left=lcaUtils(root->left,p,q,&(*ans));
    bool right=lcaUtils(root->right,p,q,&(*ans));
    bool curr=(root==p||root==q)?true:false;
    if((left&&right)||curr&&(left||right)){
        (*ans)=root;
    }
    return curr||left||right;
}

TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
    TreeNode *ans=NULL;
    bool isLCAPresent=lcaUtils(root,p,q,&ans);
    return ans;
}



TreeNode* addNode(int x){
    TreeNode* temp=(TreeNode*)malloc(sizeof(TreeNode));
    temp->val=x;
    temp->left=NULL;
    temp->right=NULL;
    return temp;
}

int main(){
    TreeNode *root=NULL;
    root=addNode(3);
    root->left=addNode(5);
    root->right=addNode(1);
    root->left->left=addNode(6);
    root->left->right=addNode(2);
    root->left->right->left=addNode(7);
    root->left->right->right=addNode(4);
    root->right->left=addNode(0);
    root->right->right=addNode(8);
    printf("%d",lowestCommonAncestor(root, root->left, root->left->right->right)->val);
    return 0;
}
