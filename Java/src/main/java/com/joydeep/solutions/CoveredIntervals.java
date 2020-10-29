package com.joydeep.solutions;

import java.util.Arrays;
import java.util.Comparator;

public class CoveredIntervals {

    public static void main(String[] args) {
        int[][] intervals = {
                {1,4},{3,6},{2,8}
        };
        System.out.println(removeCoveredIntervals(intervals));
    }
    public static int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (t0, t1) -> {
            if(t0[0]!=t1[0])
                return Integer.compare(t0[0], t1[0]);
            else return Integer.compare(t1[1], t0[1]);
        });

        int coveredIntervals = 0;
        for (int i = 0; i < intervals.length - 1; ) {
            int j = i + 1;
            while ( j<intervals.length && isIntervalCovered(intervals[j], intervals[i])) {
                coveredIntervals++;
                j++;
            }

            i = j;
        }

        return intervals.length - coveredIntervals;
    }

    private static boolean isIntervalCovered(int[] a, int[] b) {
        return a[0] >= b[0] && a[1] <= b[1];
    }
}
