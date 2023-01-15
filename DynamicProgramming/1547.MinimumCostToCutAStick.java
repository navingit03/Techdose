//leetcode 1547. Minimum Cost to Cut a Stick (recursion + memoization)

class Solution {
    Map<List<Integer>,Integer> map; //map to store the left right range key (memoization)
    public int cost(int []cuts,int left,int right){
        List<Integer> list=new ArrayList<>();
        list.add(left);
        list.add(right);
        if(map.containsKey(list)) //if already the range is present
        {
            return map.get(list); //get value
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<cuts.length;i++)
        {
            if(cuts[i]<=left||cuts[i]>=right) continue; //if cut is not in range
            int temp=cost(cuts,left,cuts[i]) + cost(cuts,cuts[i],right); //left call + right call
            min=Math.min(min,right-left+temp); //min of min and len(right-left)+temp(left call + right call)
        }
        if(min==Integer.MAX_VALUE) //not able to cut
        {
            min=0;
        }
        map.put(list,min); //add it to map - memoization
        return min;
    }
    public int minCost(int n, int[] cuts) {
        map=new HashMap<>(); //to track already found values
        return cost(cuts,0,n); //left-0 right-n
    }
}
