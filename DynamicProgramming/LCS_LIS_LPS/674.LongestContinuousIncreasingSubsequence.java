class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res=1;
        for(int i=1;i<nums.length;i++){
            int cnt=1;
            for(int j=i;j<nums.length;j++){
                if(nums[j-1]<nums[j]){
                    cnt++;
                }else{
                    break;
                }
            }
            res=Math.max(res,cnt);
        }
        return res;
    }
}
