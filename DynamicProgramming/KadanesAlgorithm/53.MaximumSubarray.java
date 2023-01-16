//leetcode 53. Maximum Subarray - Longest sum contiguous subarray
class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0],currmax=nums[0];
        for(int i=1;i<nums.length;i++){
            currmax=Math.max(nums[i],currmax+nums[i]);
            max=Math.max(max,currmax);
        }
        return max;
    }
}

