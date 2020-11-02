class Solution {
public:
    int partitioning(vector<int>& arr, int l, int h){
        printf("Entering partitioning\n");
        int i=l,j=h+1,key=arr[l],temp;
        while(i<j){
            do{
                i++;
            }while(i<j&&arr[i]<key);
            do{
                j--;
            }while(arr[j]>key);
            if(i<j){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        arr[l]=arr[j];
        arr[j]=key;
        printf("%d\n",j);
        return j;
    }

    int findKthLargestUtils(vector<int>& nums, int k, int l, int h, int absl, int absh){
        int p=partitioning(nums,l,h);
        if(p==absh-k+1)
            return nums[p];
        else if(p<absh-k+1)
            return findKthLargestUtils(nums,k,p+1,h,absl,absh);
        else
            return findKthLargestUtils(nums,k,l,p-1,absl,absh);
    }

    int findKthLargest(vector<int>& nums, int k) {
        return findKthLargestUtils(nums,k,0,nums.size()-1,0,nums.size()-1);
    }
};
