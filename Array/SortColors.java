//leetcode 75. Sort Colors
//DNF technique(Dutch)
class Solution {
    void swap(int []arr,int i,int j){
        int tem=arr[i];
        arr[i]=arr[j];
        arr[j]=tem;
    }
    public void sortColors(int[] nums) {
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0)
                swap(nums,low++,mid++);
            else if(nums[mid]==1)
                mid++;
            else if(nums[mid]==2)
                swap(nums,mid,high--);
        }
    }
}
