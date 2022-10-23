//Leetcode 2148. Count Elements With Strictly Smaller and Greater Elements
//Finding min and max value in array
class Solution {
    public int countElements(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(max>nums[i]&&nums[i]>min) //checking if min<num[i]<max cnt++;
            {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
Given an integer array nums, return the number of elements that have both a strictly smaller and a strictly greater element appear in nums.
Example 1:

Input: nums = [11,7,2,15]
Output: 2
Explanation: The element 7 has the element 2 strictly smaller than it and the element 11 strictly greater than it.
Element 11 has element 7 strictly smaller than it and element 15 strictly greater than it.
In total there are 2 elements having both a strictly smaller and a strictly greater element appear in nums.
*/
