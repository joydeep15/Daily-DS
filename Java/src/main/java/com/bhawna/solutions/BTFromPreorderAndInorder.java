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
 
class BTFromPreorderAndInorder {
    
    public TreeNode buildTreeUtil(int[] preorder,int[] inorder,int preStart,int inStart,int inEnd){
        if(preStart>=preorder.length || inStart>inEnd)
            return null;
        int currRoot=preorder[preStart];
        int currRootIndexInInorder=0;
        for(int i=inStart;i<=inEnd;i++){
            //find preorder current root index in inorder
            if(currRoot==inorder[i]){
                currRootIndexInInorder=i;
                break;
            }
        }
        TreeNode root=new TreeNode(currRoot);
        root.left=buildTreeUtil(preorder,inorder,preStart+1,inStart,currRootIndexInInorder-1);
        int nLeftChildren=currRootIndexInInorder-inStart+1;
        root.right=buildTreeUtil(preorder,inorder,(preStart+nLeftChildren),currRootIndexInInorder+1,inEnd);
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return buildTreeUtil(preorder,inorder,0,0,inorder.length);
    }
}
