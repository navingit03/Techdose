//Leetcode: 862. Shortest Subarray with Sum at Least K
//Using deque to find shortest subarray
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length,res=n+1;
        long []cum=new long[n+1]; //Creating a cumulative array
        for(int i=0;i<n;i++){
            cum[i+1]=cum[i]+nums[i]; // Adding values to the cumulative subarray
        }
        Deque<Integer> q=new ArrayDeque<>(); //Creating a deque
        for(int i=0;i<n+1;i++)
        {
            while(q.size()>0&&(cum[i]-cum[q.getFirst()]>=k)) // To check if we can reduce the size of subarray after polling the first element and still greater than k
                res=Math.min(res,i-q.pollFirst());
            while(q.size()>0 && cum[i]<=cum[q.getLast()]) // If array of index at last's value is greater than curr cumulative value then polling the last value
                q.pollLast();
            q.addLast(i); //adding index in the deque
        }
        return res<=n?res:-1; // To check if we have subarray sum atleast k
    }
}
