package com.joydeep.solutions;

public class PeakElement {

    public static void main(String[] args) {

        int[] nums = {3,2,1};
        System.out.println(findPeakElement(nums));
    }
    public static int findPeakElement(int[] nums) {

        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                }
            } else if (mid == nums.length - 1) {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                }
            } else if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }

            if (nums[mid + 1] > nums[mid]) {
                //go right
                left = mid + 1;
            }else {
                //go left
                right = mid - 1;
            }

        }
        return -1;
    }
}
