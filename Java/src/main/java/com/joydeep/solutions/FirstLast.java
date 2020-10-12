package com.joydeep.solutions;

import java.util.Arrays;

class Solution{

    public int[] searchRange(int[] nums, int target) {

        int idx = binarySearch(nums, target);
        int lowerBound = binarySearchLowerBound(nums, idx);
        int upperBound = binarySearchUpperBound(nums, idx);
        return new int[]{lowerBound, upperBound};
    }

    private int binarySearchUpperBound(int[] nums, int occuringIndex) {
        if (occuringIndex == -1) {
            return -1;
        }

        int target = nums[occuringIndex];
        int left = occuringIndex;
        int right = nums.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {

                if (mid == nums.length - 1) {
                    return mid;
                } else if (nums[mid + 1] != nums[mid]) {
                    return mid;
                }else {
                    //go right
                    left = mid + 1;
                }
            }else {
                //go left
                right = mid - 1;
            }
        }
        return left;
    }

    private int binarySearchLowerBound(int[] nums, int occuringIndex) {
        if (occuringIndex == -1) {
            return -1;
        }

        int target = nums[occuringIndex];
        int left = 0;
        int right = occuringIndex;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {

                if (mid == 0) {
                    return 0;
                } else if (nums[mid - 1] != nums[mid]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return -1;
    }
}

public class FirstLast {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6, 8, 8, 8, 8, 10, 17, 20};
        Solution s = new Solution();
        System.out.print(Arrays.toString(s.searchRange(arr, 8)));

    }
    public enum Type {
        LOWER,
        UPPER;
    }
}
