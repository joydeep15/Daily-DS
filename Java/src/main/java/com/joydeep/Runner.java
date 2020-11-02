package com.joydeep;

import com.joydeep.solutions.LRUCache;

public class Runner {
    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(1);
        lruCache.put(1, 1);
        lruCache.get(1);
        lruCache.put(2, 2);
        System.out.println(lruCache);
    }
}
