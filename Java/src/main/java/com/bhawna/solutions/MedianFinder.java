  
package com.bhawna.solutions;

import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> min_pq;  //will have second half of sorted nums (lowest as mid value of these nums)
    PriorityQueue<Integer> max_pq;  //will have first half of sorted numbs (max as mid value of these nums)
    /** initialize your data structure here. */
    public MedianFinder() {
        min_pq=new PriorityQueue<>();
        max_pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
    }
    
    public void addNum(int num) {
        //check if the number is greater than min of second half,if yes,add in min_pq else max_pq
        if(!min_pq.isEmpty() && num>min_pq.peek()){
            min_pq.offer(num);
            //allow max_pq to have one extra elt, if min_pq size > max_pq size, move one elt to max_pq
            if(min_pq.size()>max_pq.size())
                max_pq.offer(min_pq.poll());
        }
        else{            
             max_pq.offer(num);
            //System.out.println("Min pq while adding num "+min_pq.toString());
            //if max_pq size exceeds min_pq size by more than 1, balance it by moving 1 elt to min_pq
            if(min_pq.size()+1<max_pq.size()){
                min_pq.offer(max_pq.poll());
            }
        }
        
    }
    
    public double findMedian() {
      //  System.out.println("min pq: "+ min_pq.toString()+" and max pq: "+max_pq.toString());
        if(max_pq.size()==min_pq.size())
            return (double)(min_pq.peek()+max_pq.peek())/2;
        else
            return (double)max_pq.peek();
    }
}
