package com.shubham.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.shubham.utils.tree.TreeNode;
public class kthSmallestInBST {
	private static List<Integer> ans=new ArrayList();
	
	public static void kthSmallestUtils(TreeNode root) {
        if(root==null)
            return;
        kthSmallestUtils(root.left);
        ans.add((Integer) root.val);
        kthSmallestUtils(root.right);
    }
    
    public static int kthSmallest(TreeNode root, int k) {
        kthSmallestUtils(root);
        return ans.get(k-1);
    }
	
	public static void main(String[] args) {
		Integer[] ip = {4,2,5,1,3};
		List<Integer> l = Arrays.asList(ip);
		TreeNode<Integer> t = new TreeNode<>();

		TreeNode<Integer> root = t.createTree(l);
		System.out.println(kthSmallest(root,5));
	}
}
