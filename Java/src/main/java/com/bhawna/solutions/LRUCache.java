  
package com.bhawna.solutions;

import java.util.*;
import com.bhawna.solutions.utils.Node;

class LRUCache {
    //Using DLL and HashMap
    
    //head and tail are dummy nodes to point to actual head and tail nodes having data
    Node head=new Node();
    Node tail=new Node();
    HashMap<Integer,Node> keyNodeMap;
    int cacheSize;
    
    public LRUCache(int capacity) {
        keyNodeMap=new HashMap<>(capacity);
        cacheSize=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
     public int get(int key) {
        Node temp=keyNodeMap.get(key);
        int result=-1;
        if(temp!=null){
            result=temp.val;
            remove(temp);
            addInBeginning(temp);
        }
        return result;
    }
    
    public void put(int key, int value) {
       Node temp=keyNodeMap.get(key);
        //check if this key was already present in the hashmap
        if(temp!=null){
            remove(temp);
            temp.val=value;
            addInBeginning(temp);
        }
        //Not there earlier, have to be added newly
        else{
            if(keyNodeMap.size()==cacheSize){
                //remove from hashmap and DLL end
                keyNodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            
            Node new_node=new Node();
            new_node.key=key;
            new_node.val=value;
            keyNodeMap.put(key,new_node);
            addInBeginning(new_node);
        }
    }
    
    void addInBeginning(Node node){
        Node head_next=head.next;
        
        node.prev=head;
        node.next=head_next;        
        
        head_next.prev=node;
        head.next=node;
    }
    
    void remove(Node node){
        Node node_prev=node.prev;
        Node node_next=node.next;
        
        node_next.prev=node_prev;
        node_prev.next=node_next; 
    }
/* Using LinkedHashMap:
    LinkedHashMap<Integer,Integer> lru;
    int cacheSize;
    public LRUCache(int capacity) {
        cacheSize=capacity;
        lru=new LinkedHashMap<>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry entry){
                return size()>capacity;
            }
        };
        
    }
    
    public int get(int key) {
        return lru.getOrDefault(key, -1); 
    }
    
    public void put(int key, int value) {
        lru.put(key,value);
    }
    */
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
