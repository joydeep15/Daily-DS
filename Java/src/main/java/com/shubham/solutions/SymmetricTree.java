package com.shubham.solutions;

import java.util.Arrays;
import java.util.List;

import com.shubham.utils.tree.TreeNode;
public class SymmetricTree {
	
	
	public static boolean isSymmetric(TreeNode root) {
        return isSymmetricUtils(root,root);
    }
    
    public static boolean isSymmetricUtils(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null)
            return true;
        
        if(root1==null||root2==null)
            return false;
            
        boolean curr=(root1.val==root2.val)?true:false;
        return curr&&isSymmetricUtils(root1.left,root2.right)&&isSymmetricUtils(root1.right,root2.left);
    }
	public static void main(String[] args) {
		Integer[] ip = {1,2,2,3,4,4,3};
//      Integer[] ip = {1, 2, 2, null, 3, null, 3};
      List<Integer> l = Arrays.asList(ip);
      TreeNode<Integer> t = new TreeNode<>();

      TreeNode<Integer> root = t.createTree(l);
      System.out.println(isSymmetric(root));
	}
}
