package com.joydeep.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResolveIP {

    public static void main(String[] args) {
        String s = "010010";
        restoreIpAddresses(s).forEach(System.out::println);
    }



    public static List<String> restoreIpAddresses(String s) {

        if ( ! s.matches("[0-9]+")) {
            return new ArrayList<>();
        }

        List<String> container = new ArrayList<>();
        StringBuilder current = new StringBuilder(s);
        restoreIpAddresses(container, current,0, 3);
        return container;
    }

    private static void restoreIpAddresses(List<String> container, StringBuilder current,int idx, int dots) {

        //Base cases
        if (current.length() == 0 || idx >= current.length()) {
            return;
        }

        if (dots == 0) {
            //solution found
            container.add(new String(current));
            return;
        }

        /**
         * another backtracking problem
         * 1. Make a choice from the problem domain. Domain: To Place or Not To Place a Dot
         * 2. If dot is placed, Verify if the choice made is correct
         * 3. Undo the choice to explore other possibilities
         */

        //place a dot
        current.insert(idx, '.');
        if (isSafe(current, dots-1, idx)) {
            restoreIpAddresses(container, current, idx+1, dots - 1);
        }
        //remove dot(backtrack)
        current.deleteCharAt(idx);

        //explore other solutions
        restoreIpAddresses(container, current, idx + 1, dots);

    }

    public static int parseIP(String s)  {

//        remove prefix 0 like 01, 001
        if (s.startsWith("0") && s.length() > 1) {
            return -1;
        }

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    private static boolean isSafe(StringBuilder current,int remainingDots, int insertionPoint) {

        if (insertionPoint == 0) {
            return false;
        }

        int dotsPlaced = 3 - remainingDots;

        int[] octets = Arrays.stream(current.toString().split("\\.")).mapToInt(ResolveIP::parseIP).toArray();

        //if the last dot is not placed we verify all octets except the last one

        int endIdx;

        if (dotsPlaced == 3) {
            endIdx = octets.length - 1;
        } else {
            endIdx = octets.length - 2;
        }

        for (int i = 0; i <= endIdx; i++) {

            boolean valid = octets[i] >= 0 && octets[i] <= 255;
            if (!valid) {
                return false;
            }

        }

        return true;
    }

}
