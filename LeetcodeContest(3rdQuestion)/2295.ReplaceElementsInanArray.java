//Leetcode 2295. Replace Elements in an Array
class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer> map=new HashMap<>(); creating hashmap
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i); adding the key(nums[i]) and value(i) in the map
        }
        for(int[] op: operations){
            int pos=map.get(op[0]); //op[0] is the value needed to be changed, so finding the pos of op[0] in nums
            map.remove(op[0]); //removing the key in map
            nums[pos]=op[1]; // nums[pos] = op[1] value which is to be replaced 
            map.put(nums[pos],pos); //updating the map
        }
        return nums;
    }
}
/*
You are given a 0-indexed array nums that consists of n distinct positive integers.
Apply m operations to this array, where in the ith operation you replace the number operations[i][0] with operations[i][1].
It is guaranteed that in the ith operation:
operations[i][0] exists in nums.
operations[i][1] does not exist in nums.
Return the array obtained after applying all the operations.
Example 1:
Input: nums = [1,2,4,6], operations = [[1,3],[4,7],[6,1]]
Output: [3,2,7,1]
Explanation: We perform the following operations on nums:
- Replace the number 1 with 3. nums becomes [3,2,4,6].
- Replace the number 4 with 7. nums becomes [3,2,7,6].
- Replace the number 6 with 1. nums becomes [3,2,7,1].
We return the final array [3,2,7,1].
*/
