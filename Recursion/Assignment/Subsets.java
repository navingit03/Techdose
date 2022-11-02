//Leetcode 78. Subsets
class Solution {
    List<List<Integer>> list=new ArrayList<>(); //result should be list of list
    public void combination(int []arr,int index,List<Integer> temp)
    {
        if(index==arr.length) //base case
        {
            list.add(new ArrayList<>(temp)); //adding one subset
            return;
        }
        combination(arr,index+1,temp); //exclude
        temp.add(arr[index]);
        combination(arr,index+1,temp); //include
        temp.remove(temp.size()-1); //backtracking

    }
    public List<List<Integer>> subsets(int[] num)
    {
        combination(num,0,new ArrayList<>()); //calling recursion function
        return list; //return result
    }
}
