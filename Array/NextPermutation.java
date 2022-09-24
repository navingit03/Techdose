//leetcode: 31. Next Permutation
class Solution {
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int lastHigh=-1;
        int index=0;
        for(int i=1;i<n;i++){
            if(nums[i-1]<nums[i]){
                lastHigh=i;  //Find the last peak(RightMost)
            }
        }
        if(lastHigh==-1) //If the array is in descending order, we can reverse(using swap) the array and return
        {
            for(int i=0;i<n/2;i++){
                swap(nums,i,n-i-1);
            }
            return;
        }
        int swapIndex=lastHigh; //Initially keeping the swapindex to peak 
        for(int i=lastHigh+1;i<n;i++){
            if(nums[lastHigh-1]<nums[i]&&nums[lastHigh]>nums[i]){
                swapIndex=i;  //Find the index of a number which is less than peak value and greather than the nums[peak-1]
            }
        }
        swap(nums,swapIndex,lastHigh-1); //swapping swapIndex and nums[peak-1]
        Arrays.sort(nums,lastHigh,n); //sorting values between peak and last values 
        return;
    }
}
