package com.joydeep.solutions;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindRunningMedian {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(10);
        mf.addNum(20);
        System.out.println(mf.findMedian());
        mf.addNum(40);
        mf.addNum(50);
        mf.addNum(30);
        mf.addNum(25);


        System.out.println(mf.findMedian());
    }
}
class MedianFinder {

    /** initialize your data structure here. */
    private final PriorityQueue<Integer> leftHeapMax;
    private final PriorityQueue<Integer> righyHeapMin;

    public MedianFinder() {
        leftHeapMax = new PriorityQueue<>(Collections.reverseOrder());
        righyHeapMin = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if (leftHeapMax.size() == 0 && righyHeapMin.size() == 0) {
            leftHeapMax.add(num);
            return;
        }

        if (leftHeapMax.size() != 0 && num <= leftHeapMax.peek()) {
            leftHeapMax.add(num);
        }else {
            righyHeapMin.add(num);
        }

        if (righyHeapMin.size() > leftHeapMax.size() || Math.abs(leftHeapMax.size() - righyHeapMin.size()) > 1) {
            rebalance();
        }

    }

    private void rebalance() {

        boolean evenElements = ((leftHeapMax.size() + righyHeapMin.size() )% 2 ) == 0;
        int sizeDiff = evenElements ? 0 : 1;

        while (leftHeapMax.size() > righyHeapMin.size() &&
                Math.abs(leftHeapMax.size() - righyHeapMin.size()) > sizeDiff) {
            righyHeapMin.add(leftHeapMax.poll());
        }

        while (righyHeapMin.size() > leftHeapMax.size()) {
            leftHeapMax.add(righyHeapMin.poll());
        }
    }

    public double findMedian() {


        if (leftHeapMax.size() == 0) {
            return -1;
        }
        boolean evenElements = ((leftHeapMax.size() + righyHeapMin.size() )% 2 ) == 0;

        if (!evenElements) {
            return leftHeapMax.peek();
        } else  {
            if (righyHeapMin.size() > 0)
                return (double) (leftHeapMax.peek() + righyHeapMin.peek())/2;
            else return -1;
        }
    }
}