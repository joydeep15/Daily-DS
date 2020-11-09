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
    bool areSameTrees(TreeNode* s,TreeNode* t){
        printf("Hi");
        if(s==NULL&&t==NULL)
            return true;
        if(s==NULL||t==NULL)
            return false;
        return s->val==t->val&&areSameTrees(s->left,t->left)&&areSameTrees(s->right,t->right);

    }

    bool isSubtreeUtils(TreeNode* s, TreeNode* t){
        if(t==NULL)
            return true;
        if(s==NULL)
            return false;
        if(areSameTrees(s,t))
            return true;
        return isSubtreeUtils(s->left,t)||isSubtreeUtils(s->right,t);
    }

    bool isSubtree(TreeNode* s, TreeNode* t) {
        return isSubtreeUtils(s,t);
    }
};
