package com.shubham.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import com.shubham.utils.tree.TreeNode;
import com.shubham.utils.General.Pair;

public class SkylineProblem {
	
	public static List<List<Integer>> getSkyline(int[][] buildings) {
		//System.out.println(buildings[0][1]);
		
List<List<Integer>> ans = new ArrayList<List<Integer>>();
		
		List<Pair<Integer,Integer>> walls= new ArrayList<Pair<Integer,Integer>>();
        for(int i=0;i<buildings.length;i++) {
        	walls.add(new Pair(buildings[i][0],-(buildings[i][2])));
        	walls.add(new Pair(buildings[i][1],buildings[i][2]));
        }
        
        //System.out.println(walls.size());
        
        Collections.sort(walls,new Comparator<Pair<Integer, Integer>>() {
        	@Override
        	public int compare(final Pair<Integer,Integer> p1, final Pair<Integer,Integer> p2) {
        		if(p1.getL()!=p2.getL())
        			return Integer.compare(p1.getL(), p2.getL());
        		else{
                    // if(p1.getR()<0 && p2.getR()>0)
                    //     return Integer.compare(p1.getR(), p2.getR());
                    // else
                    //     return Integer.compare(p2.getR(), p1.getR());
                    return Integer.compare(p1.getR(), p2.getR());
                }
        			
        	}
		});
        
        TreeMap<Integer,Integer> h= new TreeMap<>();
        h.put(0,0);
        int top=0;
        TreeMap<Integer,Integer> ansXAxisPoints = new TreeMap<>();
        for(Pair<Integer,Integer> p: walls) {
        	System.out.println(p.getL()+" "+p.getR());
        	if(p.getR()<0) {
        		if(h.containsKey(-p.getR()))
        			h.put(-p.getR(), h.get(-p.getR())+1);
        		else
        			h.put(-p.getR(), 1);
        	}
        	else {
        		h.put(p.getR(), h.get(p.getR())-1);
        		if(h.get(p.getR())==0)
        			h.remove(p.getR());
        	}
        	if(top!=h.lastKey()) {
        		top=h.lastKey();
        		List<Integer> temp=new ArrayList<>();
        		temp.add(p.getL());
        		temp.add(top);
        		if(!ansXAxisPoints.containsKey(p.getL())) {
	        		//temp.add(p.getL());
	        		//temp.add(top);
	        		ans.add(temp);
	                ansXAxisPoints.put(p.getL(),ans.indexOf(temp));
                }
        		else {
        			ans.set(ansXAxisPoints.get(p.getL()), temp);
        		}
        		
        	}
        }
        
        return ans;
    }
	
	
	public static void main(String[] args) {
		int[][] buildings= {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		System.out.println(getSkyline(buildings));
	}
}
