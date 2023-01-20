class Solution {
    public boolean canJump(int[] nums) {
        int maxreachable=0;
        for(int i=0;i<nums.length;i++){
            if(maxreachable<i) //not able to move from some index as there will be zero
            {
                return false;
            }
            maxreachable=Math.max(maxreachable,i+nums[i]); //finding max reach from curr point
        }
        return true;
    }
}
