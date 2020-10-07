package com.joydeep.solutions;

import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<Integer> currentSolution = new ArrayList<>();
        Set<List<Integer>> allSolutions = new HashSet<>();
        getSolutions(candidates, target,allSolutions, currentSolution, target, 0);
        return new ArrayList<>(allSolutions);

    }

    /**
     *
     * @param candidates input array
     * @param target target value
     * @param allSolutions list of all the solutions
     * @param currentSolution solution so far
     * @param currentTarget target reached so far, if this value is 0 then target is reached
     * @param idx current element being processed in the input array
     */
    private static void getSolutions(int[] candidates, int target,Set<List<Integer>> allSolutions,List<Integer> currentSolution, int currentTarget, int idx) {

        if (currentTarget < 0 || idx >= candidates.length) {
            //oops undo work
            return;
        }



        if (currentTarget == 0) {
            // found a solution
            allSolutions.add(new ArrayList<>(currentSolution));
            return;
        }

        /**
         * if current sol is greater than 0, for every idx we have two options
         * either use the idx and restart from the same index or don't use the idx and resume from next el
         */

        //take the element
        currentSolution.add(candidates[idx]);
        getSolutions(candidates, target, allSolutions, currentSolution, currentTarget - candidates[idx], idx);
        //backtrack
        currentSolution.remove(currentSolution.size() - 1);
        getSolutions(candidates, target, allSolutions, currentSolution, currentTarget, idx + 1);

    }

    public static void main(String[] args) {
        int[] items = {2, 3, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum(items, target);

        result.forEach( r -> {
            r.forEach( item -> System.out.print(item+" "));
            System.out.println();
        });
    }

}
