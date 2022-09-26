//leetcode 303. Range Sum Query - Immutable
//Cummulative addition array
class NumArray {
    int arr[]; // creating array for cummulative addition
    public NumArray(int[] nums) {
        arr=nums; // copying all values in nums to arr(mainly for 0th index element)
        for(int i=1;i<nums.length;i++){
            arr[i]=arr[i]+arr[i-1]; //cummulative addition
        }
    }
    
    public int sumRange(int left, int right) {
        return left==0?arr[right]:(arr[right]-arr[left-1]); // if left==0 return the arr[right] which is sum of arr till right index.
                                                            //arr[right]-arr[left-1] return sum value of all element between left and right 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
