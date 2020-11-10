package com.shubham.utils.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    public T val;
    public Node left;
    public Node right;
    public Node next;

    public Node(T x){val = x;}
    public Node(){}

    /**
     *
     * @param tree comma separated tree nodes
     * @return
     */
    public Node<T> createTree(List<T> nodes) {

        if (nodes.isEmpty()) {
            return new Node<>();
        }

        int i = 0;
        Node<T> root = createTree(nodes, i);
        return root;

    }

    private Node<T> createTree(List<T> nodes, int i) {

        if (i >= nodes.size()) {
            return null;
        }

        Node<T> node = new Node<>(nodes.get(i));
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
