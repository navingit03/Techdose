class Solution {
    public int lengthOfLIS(int[] nums) {
        int lis[]=new int[nums.length];
        Arrays.fill(lis,1);
        int max=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && lis[j]>=lis[i]) //if i th element(right side element) is greater element than j th element(left)
                {
                    lis[i]++; //including lis[j]+1 to lis[i] as i th element is add
                    if(lis[i]>max) //if updated lis is > max
                    {
                        max=lis[i]; //update
                    }
                }
            }
        }
        return max;
    }
}
