//leetcode: 1. Two Sum
//Using hashmap
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>(); //Creating hashmap
        for(int i=0;i<nums.length;i++){
            Integer reqNum=(Integer)(target-nums[i]); //initiallizing reqNum to target(9) - currNum(2) = 7
            if(hash.containsKey(reqNum)) // if 7 contains in hashmap getting the index of num 7 inside the if condition
            {
                int arr[]={hash.get(reqNum),i}; //geting the index of 7 in the given array
                return arr; // return the two number's index
            }
            hash.put(nums[i],i); //putting the number inside(key) and its index inside the hashmap
        }
        return null;
    }
}
