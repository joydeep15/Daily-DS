package com.bhawna.solutions;

import java.util.*;

class MergeKSortedLists {
    class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    class CustomNode{
        int val;
        int listNumber; //from which list should I take the next value
        ListNode currNode;  //curr pointer in that list to pick the value from
        CustomNode(int v,int l,ListNode curr){
            val=v;
            listNumber=l;
            currNode=curr;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int k=lists.length;
        if(k<1)
            return null;
        //This pq will hold k elements at max at any point of time
        PriorityQueue<CustomNode> pq=new PriorityQueue<>(new Comparator<CustomNode>(){
            @Override
            public int compare(CustomNode c1,CustomNode c2){
                return c1.val-c2.val;
            }
        });
        ListNode result=new ListNode();
        
        //take 1 element(first viz smallest) from each list and put in pq
        for(int i=0;i<k;i++){
            if(lists[i]!=null){
                pq.offer(new CustomNode(lists[i].val,i,lists[i]));
                lists[i]=lists[i].next;
            }
        }
        
        ListNode temp=result;
        CustomNode polled;
        //Now, pick from pq and add to final result list
        while(!pq.isEmpty()){
            polled=pq.poll();
           // System.out.println("polled: "+polled.val);
            ListNode nextCustomNode=(polled.currNode).next;
            if(nextCustomNode!=null){
                pq.offer(new CustomNode(nextCustomNode.val,polled.listNumber,nextCustomNode));
            }
            temp.next=polled.currNode;
            temp=temp.next;
        }
        
        return result.next;
    }
}
