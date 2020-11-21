package com.joydeep.solutions;

import com.joydeep.utils.tree.Node;

public class NextRightPointer {
    public static Node connect(Node root) {

        if (root == null) {
            return root;
        }

        root.next = null;
        Node parent = root;

        while (parent != null) {

            Node iterator = parent;

            while (iterator != null) {

                if (iterator.left != null) {
                    if (iterator.right != null) {
                        iterator.left.next = iterator.right;
                        iterator.right.next = getNext(iterator);
                    }else {
                        iterator.left.next = getNext(iterator);
                    }
                } else if (iterator.right != null) {
                    iterator.right.next = getNext(iterator);
                }

                iterator = iterator.next;
            }

            if (parent.left != null) {
                parent = parent.left;
            } else if (parent.right != null) {
                parent = parent.right;
            }else {
                parent = getNext(parent);
            }

        }

        return root;
    }



    public static Node getNext(Node root){

        Node temp = root.next;

        while(temp!=null){

            if(temp.left!=null){
                return temp.left;
            }
            if(temp.right!=null){
                return temp.right;
            }
            temp = temp.next;
        }
        return null;
    }

}
