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
            if(maxLeft<maxRight){
                if(height[left]>maxLeft){
                    maxLeft=height[left];
                }else{
                    trappedWater+=(maxLeft-height[left]);
                }
                left++;
            }
            else{
                if(height[right]>maxRight){
                    maxRight=height[right];
                }else{
                    trappedWater+=(maxRight-height[right]);
                }
                right--;
            }
        }
        return trappedWater;
    }
}
