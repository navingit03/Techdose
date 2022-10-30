//Leetcode 525. Contiguous Array
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0) nums[i]=-1; //converting all 0 to -1
        }
        map.put(0,-1); //initially index will be -1 as we have not traversed and sum=0;
        int sum=0,max=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i]; //adding curr nums[i];
            if(map.containsKey(sum)) //if the sum is already present at starting
            {
                int lastSumIndex=map.get(sum); //its is the index when the sum is present at starting of cumSum
                max=Math.max(max,i-lastSumIndex); //from there to current index will be the have equal number of 1 and -1 so we find max
            }
            else
            {
                map.put(sum,i); //if cumSum is not present then we add it in map
            }
        }
        return max;
    }
}

/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
*/
