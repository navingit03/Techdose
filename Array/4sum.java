//Leetcode 18. 4Sum
//Using set to avoid dupilcate
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set=new HashSet<>(); //Set is used to find unique list of elements which equals to sum
        Arrays.sort(nums); //Sorting the array
        int n=nums.length;
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                int left=j+1,right=n-1; //four index pointing four different values
                while(left<right){
                    long sum=((long)nums[i]+(long)nums[j]+(long)nums[left]+(long)nums[right]); //adding four elements to sum
                    if(sum==target) //checking if sum == target
                    {
                        set.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right])); //Adding these four values in the set as list
                        left++;
                        right--;
                    }
                    else if(sum<target) left++; //if sum<target left++
                    else if(sum>target) right--; //if sum>target right++
                }
            }
        }
        return new ArrayList<>(set); //returning set as a list
    }
}
