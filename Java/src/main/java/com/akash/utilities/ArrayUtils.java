package com.akash.utilities;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(3);
        int i=0, j= list.size()-1;
        boolean res = true;
        while(i<=j){
            if(list.get(i)!=list.get(j)){
                res = false;
                break;
            }
            i++;
            j--;
        }
        System.out.println(res);;

    }
}
