package com.bhawna.solutions;

class findSmallestMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //O(n) time and O(1) space approach:
        int n=nums.length;
        boolean onePresent=false;
        for(int i=0;i<n;i++){
            if(nums[i]==1)
            {
                onePresent=true;
                break;
            }
        }
        if(!onePresent)
            return 1;
        
        //set all out of bound([1,n]) values to 1
        for(int i=0;i<n;i++){
            if(nums[i]<1 || nums[i]>n)
                nums[i]=1;
        }
        
        //Create a mapping to make numbers negative based (nums[i]-1) as index
        for(int i=0;i<n;i++){
            int c=Math.abs(nums[i]);
            nums[c-1]=-1*Math.abs(nums[c-1]);
        }
        
        //If any number is left positive, indicates that (index+1) number was missing in prevs loop
        for(int i=0;i<n;i++){
            if(nums[i]>0)
                return (i+1);
        }
        return (n+1);
        /* O(log n) time approach & O(1) space:
        if(nums.length<1)
            return 1;
        Arrays.sort(nums);
        int firstPosIndex=0;
        int posCounter=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                firstPosIndex=i;
                break;
            }
        }
        
        for(int i=firstPosIndex;i<nums.length;i++){
           // System.out.println("nums[i]="+nums[i]+" posCounter="+posCounter);
            if(nums[i]!=posCounter)
                return posCounter;
            if((i+1)<nums.length && nums[i]!=nums[i+1])
                posCounter++;
        }
        return posCounter+1;*/
    }
}
