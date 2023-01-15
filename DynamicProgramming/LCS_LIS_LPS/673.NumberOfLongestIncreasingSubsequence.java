class Solution {
    public int findNumberOfLIS(int[] nums) {
        int lis[]=new int[nums.length];
        int count[]=new int[nums.length];
        Arrays.fill(lis,1);
        Arrays.fill(count,1);
        int max=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) //if i th element(right side element) is greater element than j th element(left)
                {
                    if(lis[j]+1>lis[i])
                    {
                        lis[i]=lis[j]+1; //update list
                        count[i]=count[j]; //count i will be same as count[j]
                    }else if(lis[j]+1==lis[i])
                    {
                        count[i]+=count[j];
                    }
                }
            }
            max=Math.max(max,lis[i]);
        }
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(lis[i]==max){
                cnt+=count[i];
            }
        }
        return cnt;
    }
}
