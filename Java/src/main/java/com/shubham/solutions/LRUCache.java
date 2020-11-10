package com.shubham.solutions;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
public class LRUCache {
	private static int capacity;
	Deque<Integer> cacheList=new LinkedList<>();
	HashMap<Integer,Integer> cacheMap = new HashMap<Integer,Integer>();
	
	public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if( this.cacheMap.containsKey(key)){
        	this.cacheList.remove(key);
            this.cacheList.addFirst(key);
            return this.cacheMap.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(this.cacheMap.containsKey(key))
        	this.cacheList.remove(key);
        else if(this.capacity==this.cacheList.size()) {
        	int temp = this.cacheList.removeLast();
        	this.cacheMap.remove(temp);
        }
        this.cacheList.addFirst(key);
        this.cacheMap.put(key, value);
    }	
	
	public static void main(String[] args) {	
		LRUCache lru = new LRUCache(2);
		lru.put(1, 1);
		lru.put(2, 2);
		lru.get(1);
		lru.put(3, 3);
		System.out.println(lru.get(2));
	}
}
