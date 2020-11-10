package com.shubham.solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.shubham.utils.tree.Node;
public class RightPointerInATree {
		
	public static Node connect(Node root) {
        if(root==null||(root.left==null&&root.right==null))
        	return root;
		Queue<Node> q= new LinkedList<Node>();
        q.add(root);
        Node temp=null;
        int currSize;
		while(q.size()>0) {
        	currSize=q.size();
			for(int i=0;i<currSize;i++) {
        		temp=q.poll();
        		if(i!=currSize-1)
        			temp.next=q.peek();
        		if(temp.left!=null)
        			q.add(temp.left);
        		if(temp.right!=null)
        			q.add(temp.right);
        	}
        }
		return root;
    }
	
	
	public static void main(String[] args) {
		Integer[] ip = {1,2,3,4,5,6,7};
		List<Integer> l = Arrays.asList(ip);
		Node<Integer> t = new Node<>();

		Node<Integer> root = t.createTree(l);
		System.out.println(connect(root));
	}
}
