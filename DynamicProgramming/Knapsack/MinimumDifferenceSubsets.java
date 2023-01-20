public class MinimumDifferenceSubsets {

    public static void main(String[] args) {
        int []arr={1, 6, 11, 5};
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int target=sum/2; //find sum/2
        boolean dp[][]=new boolean[n+1][target+1]; //1 indexed dp
        for(int i=0;i<=n;i++) //index for all elements in arr
        {
            for(int j=0;j<=target;j++) //increasing capacity from 0 till target for curr i th element
            {
                if(j==0) //target is 0 then we will not include any item  - true
                {
                    dp[i][j]=true;
                }
                else if(i==0) //no item to sum upto target
                {
                    dp[i][j]=false;
                }
                else if(j<arr[i-1]) //curr element is greater than target
                {
                    dp[i][j]=dp[i-1][j]; //skip case
                }
                else
                {
                    boolean exclude=dp[i-1][j];
                    boolean include=dp[i-1][j-arr[i-1]];
                    dp[i][j]=exclude||include;
                }
            }
        }
        int sum1=0;
        for(int j=0;j<=target;j++){
            if(dp[n][j]==true) //last of all target from 0 to target which is true
            {
                sum1=j; //updating sum to lastest true on last row of dp
            }
        }
        int sum2=sum-sum1; //find sum2
        int diff=Math.abs(sum1-sum2); //min diff
        System.out.println("Min diff of two subset is "+diff);
    }
}
