//Leetcode 46. Permutations
class Solution {
    List<List<Integer>> list=new ArrayList<>(); //creating list for result
    public void swap(int []arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void premutation(int[] arr,int left,int right) //accepting array,left,right (right will be same for all which is len-1)
    {
        if(left==right) //if premutaion is found
        {
            ArrayList<Integer> a=new ArrayList<Integer>(); //creating a new list to add new permutation
            
            for(int i=0;i<arr.length;i++){
                a.add(new Integer(arr[i]));
            }
            list.add(a);
        }
        else
        {
            for(int i=left;i<=right;i++)
            {
                swap(arr,left,i); //swapping arr[left] with arr[i] to fix char at left by swapping with index i
                premutation(arr,left+1,right); //recursion call to fix next index position(left+1)
                swap(arr,left,i); //backtracking to original array
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        premutation(nums,0,nums.length-1); //recursive calling
        return list;
    }
}
