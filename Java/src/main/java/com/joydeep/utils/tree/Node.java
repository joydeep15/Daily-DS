package com.joydeep.utils.tree;

import java.util.List;

public class Node {
    //GFG Tree Format
    public Integer val;
    public Node left;
    public Node right;
    public Node next;

    public Node(Integer x){
        val = x;}
    public Node(){}

    /**
     *
     * @param tree comma separated tree nodes
     * @return
     */
    public static Node createTree(List<Integer> nodes) {

        if (nodes.isEmpty()) {
            return new Node();
        }

        int i = 0;
        Node root = createTree(nodes, i);
        return root;

    }

    private static Node createTree(List<Integer> nodes, Integer i) {

        if (i >= nodes.size()) {
            return null;
        }

        Node node = new Node(nodes.get(i));
        node.left = createTree(nodes, 2 * i + 1);
        node.right = createTree(nodes, 2 * i + 2);

        return node;

    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
