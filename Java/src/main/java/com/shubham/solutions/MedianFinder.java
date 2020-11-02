package com.shubham.solutions;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import com.shubham.utils.tree.TreeNode;
public class MedianFinder {
	static PriorityQueue<Integer> hi;
	static PriorityQueue<Integer> lo;
	
	public  MedianFinder() {
		hi=new PriorityQueue<>();
		lo=new PriorityQueue<>((a,b)->Integer.compare(b,a));
    }
    
    public void addNum(int num) {
    	lo.add(num);
    	hi.add(lo.peek());
    	lo.poll();
    	if(lo.size()<hi.size()) {
    		lo.add(hi.peek());
    		hi.poll();
    	}
    	System.out.println(lo.size());
    	System.out.println(hi.size());
    }
    
    public static double findMedian() {
        if(lo.size()>hi.size())
        	return lo.peek();
        else {
        	System.out.println(lo.peek()+hi.peek());
        	return (lo.peek()+hi.peek())*0.5;
        }
    }
	
	
	public static void main(String[] args) {
		MedianFinder obj = new MedianFinder();
		obj.addNum(1);
		System.out.println(obj.findMedian());
		obj.addNum(2);
		System.out.println(obj.findMedian());
		obj.addNum(3);
		System.out.println(obj.findMedian());
		obj.addNum(4);
		System.out.println(obj.findMedian());
	}
}
