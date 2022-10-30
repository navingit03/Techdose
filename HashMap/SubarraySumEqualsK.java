//Leetcode 560. Subarray Sum Equals K
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>(); //creating a hashmap
        int sum=0,count=0; //initially sum=0
        map.put(0,1); //put 0(currSum) and 1(count)
        for(int i=0;i<nums.length;i++){
            sum+=nums[i]; //cummulative sum
            if(map.containsKey(sum-k)) //already a sum present from o to its some index=before sum. currsum-beforesum==k then count++
            {
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1); //putting all the cumulative sum in map. if already present count++
        }
        return count;
    }
}

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.
Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
*/
