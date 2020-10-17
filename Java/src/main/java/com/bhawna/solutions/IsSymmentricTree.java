package com.bhawna.solutions;

class IsSymmentricTree {
    
    public boolean isSymmetricUtil(TreeNode root1,TreeNode root2){
        if(root1==null || root2==null)
        {
            if(root1==null && root2==null)
                return true;
            else
                return false;
        }
        if(root1.val!=root2.val)
            return false;
        return isSymmetricUtil(root1.left,root2.right) && isSymmetricUtil(root1.right,root2.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricUtil(root,root);
    }
}
