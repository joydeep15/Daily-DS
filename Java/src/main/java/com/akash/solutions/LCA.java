package com.akash.solutions;
class TreeNode{
    int value;
    TreeNode left, right;
    TreeNode(int value){
        this.value = value;
    }
}

public class LCA {
    /*Intuition: Start with root
    If root is equal to p or q root is lca.
    Traverse to left subtree and right subtree from the root.
    Consider at each node what needs to be done to find LCA
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root) return null;
        if(root == p || root == q) return root;
        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);
        if(null == leftNode) return rightNode;
        if(null == rightNode) return leftNode;
        return root;
    }
}
