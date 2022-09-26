//leetcode : 209. Minimum Size Subarray Sum
//TC: O(N)
//Sliding WIndow technique
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int left=0,right=0,sum=0;
        int shortest=Integer.MAX_VALUE; // Initiallizing int max to find shortest(min)
        while(right<n) //while right not exceed the n(size)
        {
            sum+=nums[right]; // adding elements of nums in sum
            while(sum>=target) //while the sum is greather than target
            {
                if(sum>=target) //if sum greather than target
                {
                    sum-=nums[left]; //minus the curr num from sum
                    left++; //increasing the left
                }
                shortest=Math.min(shortest,(right-left+2)); //right-left+2 gives the size of smallest subarray with sum greather than target
            }
            right++; //increasing the right
        }
        return shortest==Integer.MAX_VALUE?0:shortest;
    }
}
