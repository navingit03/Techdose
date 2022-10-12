//2289. Steps to Make Array Non-decreasing
class Solution {
    public int totalSteps(int[] nums) {
        int n=nums.length;
        int ans=0;
        Stack<Pair<Integer,Integer>> st=new Stack<>(); //Using stack
        st.push(new Pair<>(nums[n-1],0)); //adding last element
        for(int i=n-2;i>=0;i--){
            int count=0;
            while(!st.isEmpty()&&nums[i]>st.peek().getKey()) //if curr nums[i] is greater than the stack peek() then increase count and pop the element on the top
            {
                count=Math.max(count+1,st.peek().getValue());
                st.pop();
            }
            ans=Math.max(count,ans);
            st.push(new Pair(nums[i],count)); //pushing all the elements in the stack with current count 
        }
        return ans;
    }
}
/*
You are given a 0-indexed integer array nums. In one step, remove all elements nums[i] where nums[i - 1] > nums[i] for all 0 < i < nums.length.
Return the number of steps performed until nums becomes a non-decreasing array.
Input: nums = [5,3,4,4,7,3,6,11,8,5,11]
Output: 3
Explanation: The following are the steps performed:
- Step 1: [5,3,4,4,7,3,6,11,8,5,11] becomes [5,4,4,7,6,11,11]
- Step 2: [5,4,4,7,6,11,11] becomes [5,4,7,11,11]
- Step 3: [5,4,7,11,11] becomes [5,7,11,11]
[5,7,11,11] is a non-decreasing array. Therefore, we return 3.
/*
