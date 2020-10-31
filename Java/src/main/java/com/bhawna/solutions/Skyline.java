  
package com.bhawna.solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.*;

class Skyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n=buildings.length;
        List<List<Integer>> skyline=new ArrayList<>();
        if(n<1)
            return skyline;
        PriorityQueue<Integer> maxHeapHeight=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int prevMaxHeight=0;
        int currMaxHeight=0;
        maxHeapHeight.offer(0);
        
        // every point's format: [x,y,0 or 1] 0 -> start, 1-> end
        int[][] buildingPoints=new int[2*n][3];
        int i=0;
        for(int[] b:buildings){
            buildingPoints[i][0]=b[0]; //start x
            buildingPoints[i][1]=b[2]; //height y
            buildingPoints[i][2]=0;    //denotes start
                
            buildingPoints[i+1][0]=b[1]; //end x
            buildingPoints[i+1][1]=b[2]; //height y
            buildingPoints[i+1][2]=1;    //denotes end
            i+=2;
        }
        
        Arrays.sort(buildingPoints,new Comparator<int[]>(){
           @Override
            public int compare(int[] a,int[] b){
                //if both points have different x
                if(a[0]!=b[0])
                    return a[0]-b[0];
                else{
                    //if both are starting point, then first pick the one with larger height
                    if(a[2]==0 && b[2]==0)
                        return b[1]-a[1];
                    //if both are end points, then first pick the one with smaller height
                    else if(a[2]==1 && b[2]==1)
                        return a[1]-b[1];
                    //if one starts at same point where other one ends, first pick the one which starts
                    else 
                        return a[2]-b[2];
                }
            }
        });
      //  for(int j=0;j<2*n;j++)
      //      System.out.println("j="+j+" "+Arrays.toString(buildingPoints[j]));
        for(int[] b:buildingPoints){
            if(b[2]==0){
                maxHeapHeight.offer(b[1]);
            }
            else{
                maxHeapHeight.remove(b[1]);
            }
            
            //Check max height after every addition/removal of a height
            currMaxHeight=maxHeapHeight.peek();
            
            if(prevMaxHeight!=currMaxHeight){
                 skyline.add(new ArrayList<>(Arrays.asList(b[0], currMaxHeight)));
                 prevMaxHeight=currMaxHeight;
            }
        }
        return skyline;
    }
}
