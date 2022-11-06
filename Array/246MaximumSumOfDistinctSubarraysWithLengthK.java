//Leetcode 2461. Maximum Sum of Distinct Subarrays With Length K
//Sliding window approach
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set=new HashSet<>(); //set to remove duplicates
        long res=0;
        long sum=0;
        int left=0,right=0;
        while(right<nums.length)
        {
            while(set.contains(nums[right])||set.size()==k) //if nums[right] is already present in set we have to remove it by removing elements in left
            //if size of set==k we need to remove leftmost element
            {
                sum-=nums[left];
                set.remove(Integer.valueOf(nums[left])); //Integer.valueOf(nums[left]) because set is of Integer datatype
                left++;
            }
            set.add(nums[right]); //adding right element
            sum+=nums[right]; //increasing sum by nums[right]
            if(set.size()==k)
            {
            res=Math.max(res,sum); //finding max sum
            }
            right++;
        }
        return res;
    }
}
