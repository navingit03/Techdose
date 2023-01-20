class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int jumps=0;
        int curr=0;
        int maxstepfromcurr=0;
        for(int i=0;i<n-1;i++)
        {
            maxstepfromcurr=Math.max(maxstepfromcurr,i+nums[i]);
            if(curr==i)
            {
                curr=maxstepfromcurr;
                jumps++;
            }
            if(curr>n-1){
                break;
            }
        }
        return jumps;
    }
}
