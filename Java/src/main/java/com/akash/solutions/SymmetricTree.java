package com.akash.solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author goodknight
 * Problem link: https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
    /* Logic similar to mirror image of any object
    Step1: Add root two times in a queue
    Step2: Take two consecutive nodes from the queue
    Their subtrees should be symmetric.
    So, add left node from n1 node and right node from n2 and vice versa
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if(null == n1 && null == n2) continue;
            if(null == n1 || null == n2) return false;
            if(n1.value != n2.value) return false;
            queue.add(n1.left);
            queue.add(n2.right);
            queue.add(n1.right);
            queue.add(n2.left);
        }
        return true;
    }
}
