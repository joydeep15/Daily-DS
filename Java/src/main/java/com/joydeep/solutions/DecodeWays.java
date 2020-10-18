package com.joydeep.solutions;


import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static void main(String[] args) {
        String s = "123";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {

        return numDecodings(s, 0, new HashMap<>());

    }

    private static int numDecodings(String s, int index, Map<Integer, Integer> lookup) {

        if (lookup.containsKey(index)) {
            return lookup.get(index);

        }
        if (index >= s.length()) {
            return 1;
        }
        //1 char
        Integer oneChar = parse(s.substring(index, index + 1));
        Integer twoChar = -1;

        if (index + 1 < s.length()) {
            twoChar = parse(s.substring(index, index + 2));
        }

        int leftTree=0,rightTree=0;
        if (oneChar >= 1 && oneChar <= 26) {
            leftTree = numDecodings(s, index + 1,lookup);
        }

        if (twoChar >= 1 && twoChar <= 26) {
            rightTree = numDecodings(s, index + 2,lookup);
        }


        Integer value = leftTree + rightTree;
        lookup.put(index, value);
        return value;


    }

    private static Integer parse(String s) {

        if (s.startsWith("0") && s.length() > 1) {
            return -1;
        }

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException nex) {
            return -1;
        }
    }
}
