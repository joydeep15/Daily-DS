package com.akash.solutions;

import java.util.Collections;
import java.util.PriorityQueue;
/*
Solution approach:
1. Maintain a max heap and a min heap
2. Divide incoming streams into two halves
3. First half in max heap and second half in min heap
4. Keep check of size of each heap so no one is greater than one in size at any point
Example:
1 2 3 ->first half --- get the max of this so we need a max heap
4 5 6 -> 2nd half -- we need min of this so we are using a min heap
so in case of even take avg of the peek elements else take peek element from the heap which has more element
 */
class MedianFinder {
     PriorityQueue<Integer> maxHeap;
     PriorityQueue<Integer> minHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek()>num){
            maxHeap.add(num);
        } else{
            minHeap.add(num);
        }
        if(minHeap.size() > maxHeap.size() + 1){
            maxHeap.add(minHeap.peek());
            minHeap.poll();
        } else if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.peek());
            maxHeap.poll();
        }
    }

    public double findMedian() {
        double ans;
        if(minHeap.size()>maxHeap.size()){
            ans = minHeap.peek();
        } else if(maxHeap.size()>minHeap.size()){
            ans = maxHeap.peek();
        } else{
            ans =(1.0)*(minHeap.peek() + maxHeap.peek())/2;
        }
        return ans;
    }
}
public class StreamMedian {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        int[] odd = {4};
        int[] even = {4,5,6,1};
        for(int j : odd) {
            obj.addNum(j);
        }
        System.out.println(obj.maxHeap);
        System.out.println(obj.minHeap);
        double param_2 = obj.findMedian();
        System.out.println(param_2);

    }
}
