package com.joydeep.solutions;

import com.joydeep.utils.tree.TreeNode;

public class SubtreeTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if(s==null && t==null){
            return true;
        }

        if(s==null){
            return false;
        }

        if(treeEqual(s, t)){
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);

    }

    public boolean treeEqual(TreeNode a, TreeNode b){

        if(a==null && b==null){
            return true;
        }
        if( a==null ){
            return false;
        }

        if( b==null ){
            return false;
        }


        if(a.val == b.val){
            return treeEqual(a.left, b.left) && treeEqual(a.right, b.right);
        }

        return false;
    }
}
