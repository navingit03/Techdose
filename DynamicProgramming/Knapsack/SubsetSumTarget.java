public class SubsetSumTarget {
    public static boolean KPinRecursion(int arr[],int target,int index){
        if(target==0) //if subset found return true
        {
            return true;
        }
        if(index==arr.length) //if end of array is reached
        {
            return false;
        }
        if(arr[index]>target) //curr value is greater than target
        {
            return KPinRecursion(arr, target, index+1); //skip case
        }
        boolean exclude=KPinRecursion(arr, target, index+1); //to exclude change index by +1
        boolean include=KPinRecursion(arr, target-arr[index], index+1); //to include change index by +1 and decrease target by curr arr[index]
        return exclude||include; //OR operation
    }
    public static boolean KPinDP(int []arr,int target){
        boolean dp[][]=new boolean[arr.length+1][target+1]; //1 indexed dp
        for(int i=0;i<=arr.length;i++) //index for all elements in arr
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
        return dp[arr.length][target];
    }
    public static void main(String[] args) {
        int []arr={1,5,6,3};
        int target=8;
        System.out.println("TargetFound ? == "+KPinRecursion(arr,target,0));
        System.out.print("TargetFound ? == "+KPinDP(arr,target));
    }
}
