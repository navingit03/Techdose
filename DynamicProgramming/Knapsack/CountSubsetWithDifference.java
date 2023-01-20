public class CountSubsetWithDifference {
    public static int KPinRecursion(int arr[],int target,int index){
        if(target==0) //if subset found return true
        {
            return 1;
        }
        if(index==arr.length) //if end of array is reached
        {
            return 0;
        }
        if(arr[index]>target) //curr value is greater than target
        {
            return KPinRecursion(arr, target, index+1); //skip case
        }
        int excludeCount=KPinRecursion(arr, target, index+1); //to exclude change index by +1
        int includeCount=KPinRecursion(arr, target-arr[index], index+1); //to include change index by +1 and decrease target by curr arr[index]
        return excludeCount+includeCount; //adding left sub problem and right sub problem
    }
    public static int KPinDP(int []arr,int target){
        int dp[][]=new int[arr.length+1][target+1]; //1 indexed dp
        for(int i=0;i<=arr.length;i++) //index for all elements in arr
        {
            for(int j=0;j<=target;j++) //increasing capacity from 0 till target for curr i th element
            {
                if(j==0) //target is 0 then we will not include any item  - 1
                {
                    dp[i][j]=1;
                }
                else if(i==0) //no item to sum upto target - 0
                {
                    dp[i][j]=0;
                }
                else if(j<arr[i-1]) //curr element is greater than target
                {
                    dp[i][j]=dp[i-1][j]; //skip case
                }
                else
                {
                    int exclude=dp[i-1][j];
                    int include=dp[i-1][j-arr[i-1]];
                    dp[i][j]=exclude+include; //adding left sub problem and right sub problem
                }
            }
        }
        return dp[arr.length][target];
    }
    public static void main(String[] args) {
        int arr[]={3,1,2,3};
        int diff=3;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        /*
         * s1-s2=diff
         * s1-(sum-s1)=diff  (as s2=sum-s1)
         * 2*s1=diff+sum
         * s1=diff+sum/2;
         * (new goal) now problem is converted to find no of subset with sum = s1
         */
        int target=(diff+sum)/2;
        System.out.println("Number of subset with sum==s1 is "+KPinRecursion(arr,target,0));
        System.out.println("Number of subset with sum==s1 is "+KPinDP(arr,target));
    }
}
