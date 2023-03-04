class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[]=new int[2];
        int p1=0,p2=nums.length-1;
        while(p1<p2)
        {
            if(nums[p1]+nums[p2]==target)
            {
                ans[0]=p1+1;
                ans[1]=p2+1;
                break;
            }
            if(nums[p1]+nums[p2]>target)
            {
                p2--;
            }
            else
            {
                p1++;
            }
        }
        return ans;
    }
}
