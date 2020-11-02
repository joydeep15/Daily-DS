package com.joydeep.utils.linkedlist;

public class DoublyLinkedList<T> {

    int size;
    DLNode<T> head;
    DLNode<T> tail;

    public DoublyLinkedList() {
        size = 0;
    }


    public int getSize() {
        return size;
    }

    public void addToHead(DLNode<T> node) {

        if (node == null) {
            throw new IllegalArgumentException();
        }

        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }

        node.setNext(head);
        head.setPrev(node);
        head = node;
        size++;
    }

    public DLNode<T> delete(DLNode<T> node) {
        if (node == null) {
            throw new IllegalArgumentException();
        }

        if (node != head && node != tail) {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }

        if (node == head) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
        }

        if (node == tail) {
            tail = tail.getPrev();
            if (tail != null) {
                tail.setNext(null);
            }
        }

        node.setPrev(null);
        node.setNext(null);
        size--;

        return node;
    }

    public DLNode<T> getTail() {
        return tail;
    }


    public void moveNodeToHead(DLNode<T> node) {
        DLNode<T> deleted = delete(node);
        addToHead(deleted);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DLNode<T> iterator = head;
        while (iterator != null) {
            sb.append(iterator.getData()).append("->");
            iterator = iterator.getNext();
        }

        return sb.toString();
    }
}
