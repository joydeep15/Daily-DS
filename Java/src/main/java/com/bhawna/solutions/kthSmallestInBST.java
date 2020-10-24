package com.bhawna.solutions;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
 
class kthSmallestInBST {
    
    public int kthSmallest(TreeNode root, int k) {
        int[] countAndResult=new int[2];
        kSmallestUtil(root,k,countAndResult);
        return countAndResult[1];
    }
    
    public void kSmallestUtil(TreeNode root,int k,int[] countAndResult){
        if(root==null)
            return;
        kSmallestUtil(root.left,k,countAndResult);
        if(++countAndResult[0]==k){
            countAndResult[1]=root.val;
            return;
        }
        kSmallestUtil(root.right,k,countAndResult);
    }
}
