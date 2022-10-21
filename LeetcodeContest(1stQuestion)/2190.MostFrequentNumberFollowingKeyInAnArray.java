class Solution {
    public int mostFrequent(int[] nums, int key) {
        int freq[]=new int[1001];
        int max=0,maxVal=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==key){
                freq[nums[i+1]]++;
                if(max<freq[nums[i+1]]){
                    max=freq[nums[i+1]];
                    maxVal=nums[i+1];
                }
            }
        }
        return maxVal;
    }
}
/*
You are given a 0-indexed integer array nums. You are also given an integer key, which is present in nums.
For every unique integer target in nums, count the number of times target immediately follows an occurrence of key in nums.
In other words, count the number of indices i such that:
0 <= i <= nums.length - 2,
nums[i] == key and,
nums[i + 1] == target.
Return the target with the maximum count. The test cases will be generated such that the target with maximum count is unique.
Example 1:
Input: nums = [1,100,200,1,100], key = 1
Output: 100
Explanation: For target = 100, there are 2 occurrences at indices 1 and 4 which follow an occurrence of key.
No other integers follow an occurrence of key, so we return 100.
