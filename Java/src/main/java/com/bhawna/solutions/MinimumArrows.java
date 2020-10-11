package com.bhawna.solutions;

import java.util.Arrays;
import java.util.Comparator;

class MinimumArrows {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a, b) -> Integer.compare(a[1], b[1]));
        int nBalloons=points.length;
        if(nBalloons<2)
            return nBalloons;
        int end = points[0][1];
       // System.out.println("inital end "+end);
        int nArrows=1;
         for(int i=1;i<nBalloons;i++){
            if(end<points[i][0]){
                end=points[i][1];
                //System.out.println("new end "+end);
                nArrows++;
            }
        }
        return nArrows;          
    }
}
