//leetcode: 42. Trapping Rain Water
//TC-O(n) SC-O(1) 
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        if(n<=2) //if there is less than three building(<=2) we can't trap water so return 0
        {
            return 0;
        }
        int maxLeft=height[0]; //Initially MaxLeft is first element
        int maxRight=height[n-1]; //Initially MaxRight is last element
        int trappedWater=0;
        int left=1,right=n-2;
        while(left<=right){
            if(maxLeft<maxRight) //if maxRight is high
            {
                if(height[left]>maxLeft)
                {
                    maxLeft=height[left]; // if current height greather than maxLeft
                }else{
                    trappedWater+=(maxLeft-height[left]); //else adding the min(maxLeft,maxRight) - height[left]
                }
                left++;
            }
            else //if maxLeft is high
            {
                if(height[right]>maxRight){
                    maxRight=height[right]; // if current height greather than maxRigth
                }else{
                    trappedWater+=(maxRight-height[right]); //else adding the min(maxLeft,maxRight) - height[left]
                }
                right--;
            }
        }
        return trappedWater;
    }
}
