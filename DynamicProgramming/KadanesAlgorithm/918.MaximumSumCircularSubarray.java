//finding totalsum-minsum
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int maxsum=Integer.MIN_VALUE;
        int currmax=0;
        int sum=0;
        int minsum=Integer.MAX_VALUE;
        int currmin=0;
        for(int i=0;i<n;i++){
            currmax=Math.max(currmax+nums[i],nums[i]);
            maxsum=Math.max(maxsum,currmax);
            currmin=Math.min(currmin+nums[i],nums[i]);
            minsum=Math.min(minsum,currmin);
            sum+=nums[i];
        }
        if(sum==minsum) //if all are negative
        {
            return maxsum; //return min value
        }
        return Math.max(maxsum,sum-minsum);
    }
}


//TLE KadanesAlgorithm for every possible index
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int k=0;k<nums.length;k++) //starting from k th index(subarray)
        {
            int sum=0;
            for(int i=k;i<k+nums.length;i++) //from k to k+n element in circular(%n) using Kadanes Algorithm
            {
                sum+=nums[i%n];
                if(sum<nums[i%n]) //if curr sum is < nums[i]
                {
                    sum=nums[i%n]; //update
                }
                if(sum>max) //new max found
                {
                    max=sum;
                }
            }
        }
        return max;
    }
}
