package com.bhawna.solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;
        if(n<2)
            return n;
        List<int []> finalIntervals=new ArrayList<>();
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] row1,int[] row2){
                //sort on basis of start-interval value-smaller first
                if(row1[0]!=row2[0])
                    return row1[0]-row2[0];
                //if same start-interval value, 
                //sort on basis of end-interval value, larger first
                else
                    return row2[1]-row1[1];
            }
        });
        
        finalIntervals.add(intervals[0]);
        for(int i=1;i<n;i++){
            int[] lastAdded=finalIntervals.get(finalIntervals.size()-1);
            //if that can be covered by last added interval in the list
            if(intervals[i][0]>=lastAdded[0] && intervals[i][1]<=lastAdded[1])
                continue;
            //If can't be covered, add to list
            else{
                finalIntervals.add(intervals[i]);
            }
        }
        return finalIntervals.size();
    }
}
