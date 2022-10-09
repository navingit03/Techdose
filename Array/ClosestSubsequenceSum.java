//leetcode 1755. Closest Subsequence Sum
//Meet in the middle approach
class Solution {
    public void addSum(List<Long> list,int[] arr,long sum,int st){
        if(st>=arr.length){
            list.add(sum);
            return;
        }
        addSum(list,arr,sum+arr[st],st+1);
        addSum(list,arr,sum,st+1);
    }
    public int minAbsDifference(int[] nums, int goal) {
        int arr1[]=new int[nums.length/2]; //dividing nums into two parts
        int arr2[]=new int[nums.length-arr1.length];
        int k=0;
        for(int i=0;i<arr1.length;i++){
            arr1[i]=nums[k++];
        }
        for(int i=0;i<arr2.length;i++){
            arr2[i]=nums[k++];
        }
        ArrayList<Long> list1=new ArrayList<>(); //sum list for arr1
        ArrayList<Long> list2=new ArrayList<>(); //sum list for arr2
        addSum(list1,arr1,0,0); //method to find sums and add it in list
        addSum(list2,arr2,0,0);
        Collections.sort(list1); //sorting the list
        Collections.sort(list2);
        int low=0,high=list2.size()-1; //two pointers
        long res=Integer.MAX_VALUE;
        while(low<list1.size()&&high>=0){
            long total=list1.get(low)+list2.get(high); //adding two value from list1 and list2
            res=Math.min(res,Math.abs(total-goal));
            if(total>goal){
                high--;
            }
            else if(total==goal) return 0;
            else{
                low++;
            }
        }
        return (int)res;
    }
}
