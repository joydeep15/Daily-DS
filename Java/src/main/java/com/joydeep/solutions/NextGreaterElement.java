package com.joydeep.solutions;

import java.util.Stack;

public class NextGreaterElement {

//    https://leetcode.com/problems/next-greater-element-ii/

    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> st = new Stack<Integer>();
        int[] res = new int[nums.length];
        updateRes(nums, st, res);
        updateRes(nums, st, res);

        /**
         * 2nd run will remove -1 which are incorrect for a circular traversal
         *
         * Eg:
         * input: 13, 7, 6, 12
         * output: -1, 12, 12, -1
         * output: -1, 12, 12, 13 (after 2nd run)
         *
         * this happens as the larger elements will persist in the stack in the second run
         */
        return res;
    }

    private void updateRes(int[] nums, Stack<Integer> st, int[] res) {

        for (int i = nums.length - 1; i >= 0; i--) {

            while ( !st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                res[i] = -1;
            }else {
                res[i] = st.peek();
            }
            st.push(nums[i]);
        }

    }

}
