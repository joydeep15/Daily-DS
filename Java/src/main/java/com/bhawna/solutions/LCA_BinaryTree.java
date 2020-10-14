package com.bhawna.solutions;

class LCA_BinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null)
            return root;
        if(root==p || root==q)
            return root;
        
        TreeNode fromLeft=lowestCommonAncestor(root.left,p,q);
        TreeNode fromRight=lowestCommonAncestor(root.right,p,q);
        
        if((fromLeft==p && fromRight==q)||(fromLeft==q && fromRight==p))
            return root;
        return (fromLeft==null)?fromRight:fromLeft;
    }
}
