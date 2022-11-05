//Leetcode 39. Combination Sum
class Solution {
    List<List<Integer>> result;
    public void backtrack(int []arr,int target,int index,int sum,List<Integer> temp){
        if(target==sum) //if sum==target
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        if(target<sum) //if sum > target we need to go back
        {
            return;
        }
        if(index==arr.length) //end of the array
        {
            return;
        }
        temp.add(arr[index]); //adding current array[index]
        backtrack(arr,target,index,sum+arr[index],temp); //include
        temp.remove(temp.size()-1); //removing current array[index]
        backtrack(arr,target,index+1,sum,temp); //exclude
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        backtrack(candidates,target,0,0,new ArrayList<>()); //dfs method call
        return result;
    }
}
