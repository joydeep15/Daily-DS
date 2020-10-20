package com.joydeep.solutions;

import java.util.Random;

public class KthLargest {

//    https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/

    public static void main(String[] args) {

        int[] nums = {1, 5, 50, 2, 8, 9, 10, 3};
        System.out.println(findKthLargest(nums, 3));


    }

    /**
     * The idea here is to use the quickselect algorithm
     * It is nothing but a randomized quicksort where we want to converge
     * towards the target index
     * In a way its similar to binary search except the partitioning
     * is being done by the partition function
     *
     * Assuming a pseudo-random number generation, on average, we can assume
     * that the array has been split into two equal halves
     *
     * Time Complexity:
     *        No Of Comparisons = n + 1/2 n + 1/4 n + 1/8 n + ....
     *                          = n(2)
     *                          = O(n) [Average]
     *
     * @param nums input array
     * @param k kth largest
     * @return the kth largest element
     */
    public static int findKthLargest(int[] nums, int k) {

        if (k > nums.length) {
            return -1;
        }

        int target = nums.length - k ;

        int left = 0;
        int right = nums.length - 1;
        Random random = new Random();

        while (left <= right) {

            int rando = random.nextInt(right - left + 1);
            int pivotElement = left + rando;
            swap(nums, pivotElement, right);
            int partitionIdx = partition(nums, left, right);

            if (partitionIdx == target) {
                return nums[partitionIdx];
            }

            if (target < partitionIdx) {
                //go left
                right = partitionIdx - 1;
            }else {
                left = partitionIdx + 1;
            }

        }

        return nums[target];
    }

    private static int partition(int[] nums, int start, int end) {

        int pivot = nums[end];
        int leftIdx = start - 1;

        for (int j = start; j <= end - 1; j++) {

            if (nums[j] <= pivot) {
                leftIdx++;
                swap(nums, j, leftIdx);
            }
        }

        leftIdx++;
        swap(nums, leftIdx, end);
        return leftIdx;
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

}
