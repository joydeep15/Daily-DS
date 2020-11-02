package com.joydeep.solutions;

import com.joydeep.utils.common.Pair;
import com.joydeep.utils.linkedlist.DLNode;
import com.joydeep.utils.linkedlist.DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final int MAX_SIZE;
    private final DoublyLinkedList<Pair<Integer, Integer>> dqueue;
    private final Map<Integer, DLNode<Pair<Integer, Integer>>> cache;

    public LRUCache(int capacity) {
        MAX_SIZE = capacity;
        cache = new HashMap<>();
        dqueue = new DoublyLinkedList<>();
    }

    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }

        DLNode<Pair<Integer, Integer>> node = cache.get(key);
        dqueue.moveNodeToHead(node);
        return node.getData().getSecond();

    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            dqueue.moveNodeToHead(cache.get(key));
            cache.get(key).getData().setSecond(value);
            return;
        }

        if (dqueue.getSize() < MAX_SIZE) {

            DLNode<Pair<Integer, Integer>> node = new DLNode<>(new Pair<>(key, value));
            dqueue.addToHead(node);
            cache.put(key, node);
        }else {

            DLNode<Pair<Integer, Integer>> last = dqueue.getTail();
            cache.remove(last.getData().getFirst());
            dqueue.delete(last);
            DLNode<Pair<Integer, Integer>> node = new DLNode<>(new Pair<>(key, value));
            dqueue.addToHead(node);
            cache.put(key, node);
        }
    }

    @Override
    public String toString() {
        return dqueue.toString();
    }
}
