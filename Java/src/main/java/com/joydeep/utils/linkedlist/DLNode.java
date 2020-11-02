package com.joydeep.utils.linkedlist;

public class DLNode<T> {

    private T data;
    private DLNode<T> next;
    private DLNode<T> prev;

    public DLNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {return data;}
    public void setData(T data) {this.data = data;}

    public DLNode<T> getNext() {return next;}
    public void setNext(DLNode<T> next) {this.next = next;}

    public DLNode<T> getPrev() {return prev;}
    public void setPrev(DLNode<T> prev) {this.prev = prev;}
}
