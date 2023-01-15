//leetcode 1691. Maximum Height by Stacking Cuboids by dp
class Solution {
    public int maxHeight(int[][] cuboids) {
        for(int []a:cuboids){
            Arrays.sort(a); //sorting every row (rearrange dimensions)
        }
        Arrays.sort(cuboids, new Comparator<int[]>(){ //sort matrix by first value larger of col
            public int compare(int []a,int []b){
                if(a[0]!=b[0]){
                    return b[0]-a[0];
                }
                if(a[1]!=b[1]){
                    return b[1]-a[1];
                }
                return b[2]-a[2];
            }
        });
        int n=cuboids.length;
        int res=0;
        int dp[]=new int[n];
        for(int j=0;j<n;j++){
            dp[j]=cuboids[j][2]; //curr height
            for(int i=0;i<j;i++) //searching for greater cube before j (from 0 till j)
            {
                if(cuboids[i][0]>=cuboids[j][0]&&cuboids[i][1]>=cuboids[j][1]&&cuboids[i][2]>=cuboids[j][2]) //if all dimensions of i is >= j
                {
                    dp[j]=Math.max(dp[j],dp[i]+cuboids[j][2]); //update dp[j] by adding dp[i]+curr height
                }
            }
            res=Math.max(res,dp[j]);
        }
        return res;
    }
}
