//33. Search in Rotated Sorted Array
//TC: O(n)
class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        int mid;
        while(left<=right){
            mid=left+(right-left)/2; //finding mid
            if(nums[mid]==target){
                return mid; //return target's index
            }
            else if(nums[left]<=nums[mid]) //if numbers between left and mid is strictly increasing
            {
                if(nums[left]<=target&&nums[mid]>=target) // if target is present in range of left and mid
                {
                    right=mid-1; //making right to mid-1
                }
                else{
                    left=mid+1; //making left to mid+1
                }
            }
            else ////if numbers between mid and right is strictly increasing
            {
                if(nums[mid]<=target&&nums[right]>=target)// if target is present in range of mid and right
                {
                    left=mid+1; //making left to mid+1
                }
                else{
                    right=mid-1; //making right to mid-1
                }
            }
        }
        return -1;
    }
}
