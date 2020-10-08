package com.joydeep.solutions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {

        List<String> parenthesis = generateParenthesis(3);
        parenthesis.forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        generateParenthesis(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    /**
     *
     * @param finalResult container for storing all the results
     * @param currentResult current result that is being explored
     * @param leftCount number of left brackets in currentResult
     * @param rightCount number of right brackets in currentResult
     * @param numBrackets max number of left and right brackets ( Total brackets = 2*numBrackets )
     */
    private static void generateParenthesis(List<String> finalResult, StringBuilder currentResult, int leftCount, int rightCount, int numBrackets) {

        if (leftCount == rightCount && leftCount == numBrackets) {
            //solution found
            finalResult.add(new String(currentResult));
        }

        /**
         * Classic backtracking problem which will involve 3 steps
         * 1. Make a choice from the problem domain. Domain here: '(' , ')'
         * 2. Validate if the choice made is correct. This is done by the isSafe function
         * 3. Remove the choice made to explore other possibilites
         */

        //check if adding leftBracket is safe
        if (isSafe(currentResult,leftCount + 1, rightCount, numBrackets)) {
            currentResult.append('(');
            generateParenthesis(finalResult, currentResult, leftCount + 1, rightCount, numBrackets);

        }

        //check if adding rightBracket is safe
        if (isSafe(currentResult, leftCount, rightCount + 1, numBrackets)) {
            currentResult.append(')');
            generateParenthesis(finalResult, currentResult, leftCount, rightCount + 1, numBrackets);
        }

        // remove choice(backtrack)
        if (currentResult.length() > 0) {
            currentResult.deleteCharAt(currentResult.length() - 1);
        }

    }

    private static boolean isSafe(StringBuilder currentResult, int leftcount, int rightCount, int numBrackets) {

        if (leftcount > numBrackets || rightCount > numBrackets) {
            return false;
        }

        return rightCount <= leftcount;
    }


}
