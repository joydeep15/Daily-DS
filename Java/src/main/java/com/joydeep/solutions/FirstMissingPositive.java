package com.joydeep.solutions;

public class FirstMissingPositive {

    public static void main(String[] args) {

        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));

    }

    /**
     * to do it in constant space, we convert the array into
     * a hashset
     * +ve number -> not visited
     * -ve number -> visited
     * visit all array indices and mark as visited
     * last unvisited index is sol
     * or solution is n+1
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {

        int negDivision = shuffleSeg(nums);
        int n;
        int lowerBound = 0;
        if (negDivision >= 0) {
            n = nums.length - negDivision - 1;
            lowerBound = negDivision + 1;
        }else {
            n = nums.length;
        }

        for(int i = lowerBound; i < nums.length; i++ ){
            int val = Math.abs(nums[i]);
            if(val <= n && nums[lowerBound + val - 1] > 0){
                nums[lowerBound + val - 1] = -nums[lowerBound + val - 1];
            }
        }

        for(int i = negDivision + 1; i < nums.length; i++){
            if(nums[i] > 0){
                return i - lowerBound + 1;
            }
        }

        return n + 1;

    }

    /**
     *  this moves all negative and 0's to the beginning of
     *  the array and returns the index of last negative number
     * @param nums array
     * @return the index of last negative or zero idx
     */
    private static int shuffleSeg(int[] nums){

        int neg = -1;
        for(int i = 0; i < nums.length; i++){

            if(nums[i] <= 0){
                neg++;
                swap(nums, i, neg);
            }
        }

        return neg;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
