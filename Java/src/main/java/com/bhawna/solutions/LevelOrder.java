package com.bhawna.solutions;

import java.util.LinkedList; 
import java.util.Queue; 

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

class LevelOrder {
   
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
            return ans;
        queue.offer(root);
        
        List<Integer> subans=new ArrayList<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            //remove all present in queue;maintain only nodes of one level
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                subans.add(curr.val);
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
            }
            ans.add(subans);
           subans=new ArrayList<Integer>();
        }
        
        return ans;
    }
}
