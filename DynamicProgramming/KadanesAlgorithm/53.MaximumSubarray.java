//leetcode 53. Maximum Subarray - Longest sum contiguous subarray
class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum<nums[i]) //if curr sum is < nums[i]
            {
                sum=nums[i]; //update
            }
            if(sum>max) //new max found
            {
                max=sum;
            }
        }
        return max;
    }
}

