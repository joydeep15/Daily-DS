package com.shubham.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.shubham.utils.tree.TreeNode;
public class LevelOrder {
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
        if (root==null)
        	return ans;
        int levelSize;
        q.add(root);
        TreeNode front=null;
        while(!q.isEmpty()) {
        	levelSize=q.size();
        	List<Integer> temp=new ArrayList<>();
        	for(int i=0;i<levelSize;i++) {
        		front = q.poll();
        		temp.add((Integer)front.val);
        		if(front.left!=null)
        			q.add(front.left);
        		if(front.right!=null)
        			q.add(front.right);
        	}
        	ans.add(temp);
        }
        return ans;
    }
	
	
	public static void main(String[] args) {
		Integer[] ip = {1,2,2,3,4,4,3};
		List<Integer> l = Arrays.asList(ip);
		TreeNode<Integer> t = new TreeNode<>();

		TreeNode<Integer> root = t.createTree(l);
		System.out.println(levelOrder(root));
	}
}
