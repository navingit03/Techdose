//leetcode: 15. 3Sum
//TC: O(n^2)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>(); //creating list for the output result
        Arrays.sort(nums); // sorting the array to avoid duplicates(Ex: -5,0,5 is possible but 5,0,-5 not possiible as it is in not ascending order)
        int len=nums.length;   
        if(len<=2) //we need minimum 3 numbers
        {
            return res; 
        }
        HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>(); //creating hashmap for finding thrid number
        for(int i=0;i<len;i++){
            hash.put(nums[i],i); // adding all number and it's index
        }
        Set<String> used=new HashSet<>(); //creating set to avoid duplicates
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int currNum=nums[i]+nums[j]; //adding two numbers
                if(hash.containsKey(-1*currNum)) //finding thrid number(3rdNum-currNum==0) so it is (-1*currNum)
                {
                    int index=hash.get(-1*currNum); //finding index of 3rdNum in nums
                    if(!used.contains(nums[i]+":"+nums[j]+":"+nums[index])&&index>i&&index>j) //if these three nos already not in set and index>(i&j)
                    {
                        res.add(Arrays.asList(nums[i],nums[j],nums[index])); // add in the res list
                        used.add(nums[i]+":"+nums[j]+":"+nums[index]); //adding in set 
                    }
                }
            }
        }
        return res;
    }
}
