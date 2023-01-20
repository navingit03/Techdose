class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(a,b)->(a[0]-a[1])-(b[0]-b[1])); //sorting based on difference
        int ans=0;
        for(int i=0;i<costs.length;i++)
        {
            if(i<(costs.length/2)) //first half travel to city A
            {
                ans+=costs[i][0];
            }else //second half travel to city B
            {
                ans+=costs[i][1];
            }
        }
        return ans;
    }
}
